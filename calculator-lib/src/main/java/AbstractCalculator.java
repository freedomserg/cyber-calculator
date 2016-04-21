import java.util.*;

public abstract class AbstractCalculator<T> {
    protected ExecutedCalculatorOperations operations;
    protected Deque<T> computingStack;
    protected List<String> expressionInPostfixNotation;
    protected Validator validator;
    protected Converter converter;

    public AbstractCalculator(ExecutedCalculatorOperations operations, Deque<T> computingStack,
                              List<String> expressionInPostfixNotation, Validator validator) {
        this.operations = operations;
        this.computingStack = computingStack;
        this.expressionInPostfixNotation = expressionInPostfixNotation;
        this.validator = validator;
        this.converter = new Converter(operations);
    }

    public T evaluateExpression(String inputExpression) {
        validator.validateExpressionAndCheckAcceptableOperations(inputExpression, operations);
        return compute(converter.convertToPostfixNotation(inputExpression));
    }

    T compute(List<String> postfixNotation) {
        return null;
    }



}
