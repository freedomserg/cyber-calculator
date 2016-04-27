import calculatorExceptions.EmptyBracketsCalculatorException;
import calculatorExceptions.MismatchBracketsCalculatorException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Converter<T> {
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
                addNumberToConvertedExpression(arg);

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
                        addNumberToConvertedExpression(stackOfOperators.pop());
                    }
                    removeOpeningBrace();

                } else if (getOperationPriority(arg) <= getOperationPriority(stackOfOperators.peek())) {
                    while (getSizeOfStackOfOperators() > 0 && getOperationPriority(arg) <= getOperationPriority(stackOfOperators.peek())) {
                        addNumberToConvertedExpression(stackOfOperators.pop());
                    }
                    stackOfOperators.push(arg);

                } else {
                    stackOfOperators.push(arg);
                }

            } else {
                stackOfOperators.push(arg);
            }
        }

        while (getSizeOfStackOfOperators() > 0) {
            if (stackOfOperators.contains("(")) {
                throw new MismatchBracketsCalculatorException();
            }
            addNumberToConvertedExpression(stackOfOperators.pop());
        }

        return expressionInPostfixNotation;
    }

    private boolean isClosingBrace(String part) {
        return ")".equals(part);
    }

    private void removeOpeningBrace() {
        stackOfOperators.removeFirst();
    }

    private boolean isOpeningBrace(String part) {
        return "(".equals(part);
    }

    private int getSizeOfStackOfOperators() {
        return stackOfOperators.size();
    }

    private void addNumberToConvertedExpression(String part) {
        expressionInPostfixNotation.add(part);
    }

    private boolean isOperator(String part) {
        return operations.containsOperation(part);
    }

    private Integer getOperationPriority(String operationLiteral) {
        return operations.getOperation(operationLiteral).getPriority();
    }
}
