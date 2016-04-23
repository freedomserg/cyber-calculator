import java.util.*;

public abstract class AbstractCalculator<T> {
    protected ExecutedCalculatorOperations<T> operations;
    protected Deque<T> computingStack;
    protected Validator validator;
    protected Converter<T> converter;

    public AbstractCalculator() {
        this.computingStack = new ArrayDeque<>();
        initExecutedOperations();
        initConverter();
        initValidator();
    }

    protected abstract void initExecutedOperations();

    protected abstract void initConverter();

    protected abstract void initValidator();

    public T evaluateExpression(String inputExpression) {
        validator.validateExpressionAndCheckAcceptableOperations(inputExpression, operations);
        return compute(converter.convertToPostfixNotation(inputExpression));
    }

    private T compute(List<String> postfixNotation) {
        for (String arg : postfixNotation) {
            if (!isOperator(arg)) {
                addNumberToComputingStack(arg);
            } else {
                computingStack.push(executeOperation(arg));
            }
        }
        return computingStack.pop();
    }

    private boolean isOperator(String arg) {
        return operations.containsOperation(arg);
    }

    protected abstract void addNumberToComputingStack(String number);

    protected T executeOperation(String operationLiteral) {
        Operation<T> operation = operations.getOperation(operationLiteral);
        Arguments<T> arguments = getArguments(operation);
        return operation.getResult(arguments);
    }

    protected Arguments<T> getArguments(Operation<T> operation) {
        Arguments<T> arguments = new Arguments<>();
        if (operation instanceof BinaryOperation) {
        arguments.secondArg = computingStack.pop();
        }
        arguments.firstArg = computingStack.pop();
        return arguments;
    }
}