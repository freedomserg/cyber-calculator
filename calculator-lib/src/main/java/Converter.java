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

            if (!isOperator(arg)) {
                popOperatorsToConvertedExpression(arg);

            } else if (getSizeOfStackOfOperators() > 0) {

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
                        popOperatorsToConvertedExpression(stackOfOperators.pop());
                    }
                    removeOpeningBrace();

                } else if (isRightAssociated(arg)) {

                    if (isCurrentOperationPriorityLessThanTopStackOperationPriority(arg)) {
                        while (getSizeOfStackOfOperators() > 0 &&
                                isCurrentOperationPriorityLessThanTopStackOperationPriority(arg)) {
                            popOperatorsToConvertedExpression(stackOfOperators.pop());
                        }
                        stackOfOperators.push(arg);
                    }  else {
                        stackOfOperators.push(arg);
                    }

                } else {
                    if (isCurrentOperationPriorityLessOrEqualsTopStackOperationPriority(arg)) {
                        while (getSizeOfStackOfOperators() > 0 &&
                                isCurrentOperationPriorityLessOrEqualsTopStackOperationPriority(arg)) {
                            popOperatorsToConvertedExpression(stackOfOperators.pop());
                        }
                        stackOfOperators.push(arg);
                    }  else {
                        stackOfOperators.push(arg);
                    }
                }

            } else {
                stackOfOperators.push(arg);
            }
        }

        while (getSizeOfStackOfOperators() > 0) {
            if (stackOfOperators.contains("(")) {
                throw new MismatchBracketsCalculatorException();
            }
            popOperatorsToConvertedExpression(stackOfOperators.pop());
        }

        return expressionInPostfixNotation;
    }

    private boolean isCurrentOperationPriorityLessOrEqualsTopStackOperationPriority(String arg) {
        return getOperationPriority(arg) <= getOperationPriority(stackOfOperators.peek());
    }

    private boolean isCurrentOperationPriorityLessThanTopStackOperationPriority(String arg) {
        return getOperationPriority(arg) < getOperationPriority(stackOfOperators.peek());
    }

    private boolean isRightAssociated(String arg) {
        return operations.getOperation(arg) instanceof RightAssociated;
    }

    private boolean isClosingBrace(String arg) {
        return ")".equals(arg);
    }

    private void removeOpeningBrace() {
        stackOfOperators.removeFirst();
    }

    private boolean isOpeningBrace(String arg) {
        return "(".equals(arg);
    }

    private int getSizeOfStackOfOperators() {
        return stackOfOperators.size();
    }

    private void popOperatorsToConvertedExpression(String operator) {
        expressionInPostfixNotation.add(operator);
    }

    private boolean isOperator(String arg) {
        return operations.containsOperation(arg);
    }

    private Integer getOperationPriority(String operationLiteral) {
        return operations.getOperation(operationLiteral).getPriority();
    }
}