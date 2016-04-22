import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Converter<T> {
    private Deque<String> stackOfOperators;
    private List<String> expressionInPostfixNotation;
    private ExecutedCalculatorOperations<T> operations;

    public Converter(ExecutedCalculatorOperations<T> operations) {
        this.stackOfOperators = new ArrayDeque<>();
        this.expressionInPostfixNotation = new ArrayList<>();
        this.operations = operations;
    }

    List<String> convertToPostfixNotation(String validatedString) {
        String[] partsOfInfixNotation = validatedString.split(" ");

        for (String part : partsOfInfixNotation) {

            if (!isOperator(part)) {
                addNumberToConvertedExpression(part);

            } else if (sizeOfStackOfOperators() > 0) {

                if (isOpeningBrace(part)) {
                    stackOfOperators.push(part);

                } else if (isClosingBrace(part)) {
                    if (isOpeningBrace(stackOfOperators.peek())) {
                        //throw new EmptyBracketsCalculatorException();
                        throw new RuntimeException();
                    }
                    if (!stackOfOperators.contains("(")) {
                        //throw new MismatchBracketsCalculatorException();
                        throw new RuntimeException();
                    }
                    while (sizeOfStackOfOperators() > 0 && !isOpeningBrace(stackOfOperators.peek())) {
                        addNumberToConvertedExpression(stackOfOperators.pop());
                    }
                    removeOpeningBracket();

                } else if (getOperationPriority(part) <= getOperationPriority(stackOfOperators.peek())) {
                    while (sizeOfStackOfOperators() > 0 && getOperationPriority(part) <= getOperationPriority(stackOfOperators.peek())) {
                        addNumberToConvertedExpression(stackOfOperators.pop());
                    }
                    stackOfOperators.push(part);

                } else {
                    stackOfOperators.push(part);
                }

            } else {
                stackOfOperators.push(part);
            }
        }

        while (sizeOfStackOfOperators() > 0) {
            if (stackOfOperators.contains("(")) {
                //throw new MismatchBracketsCalculatorException();
                throw new RuntimeException();
            }
            addNumberToConvertedExpression(stackOfOperators.pop());
        }

        return expressionInPostfixNotation;
    }

    private boolean isClosingBrace(String part) {
        return ")".equals(part);
    }

    private void removeOpeningBracket() {
        stackOfOperators.removeFirst();
    }

    private boolean isOpeningBrace(String part) {
        return "(".equals(part);
    }

    private int sizeOfStackOfOperators() {
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
