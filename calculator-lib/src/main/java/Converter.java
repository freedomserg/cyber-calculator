import calculatorExceptions.EmptyBracketsCalculatorException;
import calculatorExceptions.MismatchBracketsCalculatorException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Converter {
    private Deque<String> stackOfOperators;
    private List<String> expressionInPostfixNotation;
    private ExecutedCalculatorOperations operations;

    public Converter(ExecutedCalculatorOperations operations) {
        this.stackOfOperators = new ArrayDeque<>();
        this.expressionInPostfixNotation = new ArrayList<>();
        this.operations = operations;
    }

    List<String> convertToPostfixNotation(String validatedString) {
        String[] partsOfInfixNotation = validatedString.split(" ");

        for (String arg : partsOfInfixNotation) {

            if (isOperator(arg)) {
                if (getSizeOfStackOfOperators() > 0) {

                    if (isOpeningBrace(arg)) {
                        stackOfOperators.push(arg);
                    } else if (isClosingBrace(arg)) {
                        if (isOpeningBrace(stackOfOperators.peek())) {
                            throw new EmptyBracketsCalculatorException();
                        }
                        if (!stackOfOperators.contains("(")) {
                            throw new MismatchBracketsCalculatorException();
                        }
                        while (getSizeOfStackOfOperators() > 0 && !isOpeningBrace(stackOfOperators.peek())) {
                            popOperatorToConvertedExpression(stackOfOperators.pop());
                        }
                        removeOpeningBrace();
                    } else if (isRightAssociated(arg)) {
                        if (isCurrentOperationPriorityLessThanTopStackOperationPriority(arg)) {
                            while (getSizeOfStackOfOperators() > 0 &&
                                    isCurrentOperationPriorityLessThanTopStackOperationPriority(arg)) {
                                popOperatorToConvertedExpression(stackOfOperators.pop());
                            }
                            stackOfOperators.push(arg);
                        }  else {
                            stackOfOperators.push(arg);
                        }
                    } else {
                        if (isCurrentOperationPriorityLessOrEqualsTopStackOperationPriority(arg)) {
                            while (getSizeOfStackOfOperators() > 0 &&
                                    isCurrentOperationPriorityLessOrEqualsTopStackOperationPriority(arg)) {
                                popOperatorToConvertedExpression(stackOfOperators.pop());
                            }
                            stackOfOperators.push(arg);
                        }  else {
                            stackOfOperators.push(arg);
                        }
                    }
                } else {
                    stackOfOperators.push(arg);
                }
            } else {
                popOperatorToConvertedExpression(arg);
            }
        }

        while (getSizeOfStackOfOperators() > 0) {
            if (stackOfOperators.contains("(")) {
                throw new MismatchBracketsCalculatorException();
            }
            popOperatorToConvertedExpression(stackOfOperators.pop());
        }

        return expressionInPostfixNotation;
    }


    private boolean isOperator(String arg) {
        return operations.containsOperation(arg);
    }

    private int getSizeOfStackOfOperators() {
        return stackOfOperators.size();
    }

    private boolean isOpeningBrace(String arg) {
        return "(".equals(arg);
    }

    private boolean isClosingBrace(String arg) {
        return ")".equals(arg);
    }

    private void popOperatorToConvertedExpression(String operator) {
        expressionInPostfixNotation.add(operator);
    }

    private void removeOpeningBrace() {
        stackOfOperators.removeFirst();
    }

    private boolean isRightAssociated(String operator) {
        return operations.getOperation(operator) instanceof RightAssociated;
    }

    private boolean isCurrentOperationPriorityLessThanTopStackOperationPriority(String operator) {
        return getOperationPriority(operator) < getOperationPriority(stackOfOperators.peek());
    }

    private boolean isCurrentOperationPriorityLessOrEqualsTopStackOperationPriority(String operator) {
        return getOperationPriority(operator) <= getOperationPriority(stackOfOperators.peek());
    }

    private Integer getOperationPriority(String operator) {
        return operations.getOperation(operator).getPriority();
    }
}