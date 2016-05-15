import java.util.*;

public abstract class AbstractCalculator<T> {
    protected ExecutedCalculatorOperations operations;
    protected Deque<T> computingStack;
    protected Validator validator;
    protected Converter converter;

    public AbstractCalculator() {
        this.computingStack = new ArrayDeque<>();
        initExecutedOperations();
        initConverter();
        initValidator();
    }

    private void initExecutedOperations() {
        operations = new ExecutedCalculatorOperations();
        operations.addOperation("+", new Addition(1));
        operations.addOperation("-", new Subtraction(1));
        operations.addOperation("*", new Multiplication(2));
        operations.addOperation("/", new Division(2));
        operations.addOperation("sqr", new Squaring(3));
        operations.addOperation("sqrt", new SquareRoot(3));
        operations.addOperation("ln", new NaturalLogarithm(3));
        operations.addOperation("!", new Factorial(3));
    }

    public void addNewOperation(String operationLiteral, Operation operation) {
        operations.addOperation(operationLiteral, operation);
    }

    protected abstract void initConverter();

    protected abstract void initValidator();

    public T evaluateExpression(String inputExpression) {
        validator.validateExpressionAndCheckAcceptableOperations(inputExpression, operations);
        return compute(converter.convertToPostfixNotation(inputExpression));
    }

    T compute(List<String> postfixNotation) {
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

    protected abstract T executeOperation(String operationLiteral);

    protected abstract Arguments<T> getArguments(Operation operation);
}