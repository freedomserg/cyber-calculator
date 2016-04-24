import CalculatorExceptions.InvalidInputExpressionCalculatorException;
import org.junit.BeforeClass;

public class IntegersValidatorImplTest {
    private String input;
    static ExecutedCalculatorOperations<Integer> integersOperations;

    @BeforeClass
    public static void initDoublesExecutedOperations() {
        integersOperations = new ExecutedCalculatorOperations<>();
        integersOperations.addOperation("+", new IntegersAddition(1));
        integersOperations.addOperation("-", new IntegersSubtraction(1));
    }

    @org.junit.Test
    public void testValidatorWithCorrectExpression() {
        input = "33 - ( 197 - ( 22 + 67 ) )";
        Validator validator = new IntegersValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, integersOperations);
    }

    @org.junit.Test(expected = InvalidInputExpressionCalculatorException.class)
    public void testValidatorWithIncorrectExpression() {
        input = "336 - 75.5 + !12 - 3 )";
        Validator validator = new IntegersValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, integersOperations);
    }

}