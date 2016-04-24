import CalculatorExceptions.InvalidInputExpressionCalculatorException;
import org.junit.*;

public class DoublesValidatorImplTest {
    private String input;
    static ExecutedCalculatorOperations<Double> doublesOperations;

    @BeforeClass
    public static void initDoublesExecutedOperations() {
        doublesOperations = new ExecutedCalculatorOperations<>();
        doublesOperations.addOperation("+", new DoublesAddition(1));
        doublesOperations.addOperation("-", new DoublesSubtracting(1));
    }

    @org.junit.Test
    public void testValidatorWithCorrectExpression() {
        input = "7.12 + 45.56 - ( 12.9 - 6.2 )";
        Validator validator = new DoublesValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, doublesOperations);
    }

    @org.junit.Test(expected = InvalidInputExpressionCalculatorException.class)
    public void testValidatorWithIncorrectExpression() {
        input = "18,78 - 13.33? + { 16.75 - 6.1 }";
        Validator validator = new DoublesValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, doublesOperations);
    }

}