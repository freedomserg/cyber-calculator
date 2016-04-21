import java.util.Map;

public interface Validator {
    void validateExpressionAndCheckAcceptableOperations(String inputExpression, ExecutedCalculatorOperations operations);
}
