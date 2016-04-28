import calculatorExceptions.InvalidInputExpressionCalculatorException;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntegersValidatorImplTest {
    private String input;
    private static ExecutedCalculatorOperations integersOperations;

    @BeforeClass
    public static void initIntegersExecutedOperations() {
        integersOperations = new ExecutedCalculatorOperations();
        integersOperations.addOperation("+", new Addition(1));
        integersOperations.addOperation("-", new Subtraction(1));
        integersOperations.addOperation("sqr", new Squaring(3));
        integersOperations.addOperation("sqrt", new SquareRoot(3));
        integersOperations.addOperation("ln", new NaturalLogarithm(3));
        integersOperations.addOperation("!", new Factorial(3));
    }

    @Test
    public void testValidatorWithCorrectExpression() {
        input = "33 - ( 197 - ( 22 + 67 ) )";
        Validator validator = new IntegersValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, integersOperations);
    }

    @Test(expected = InvalidInputExpressionCalculatorException.class)
    public void testValidatorWithIncorrectExpression() {
        input = "336 - 75.5 + !12 - 3 )";
        Validator validator = new IntegersValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, integersOperations);
    }

    @Test
    public void testValidateIntegerOperations() {
        input = "ln 15 + ( sqrt 64 - sqr 10 + 2 ! )";
        Validator validator = new IntegersValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, integersOperations);
    }

    @Test(expected = InvalidInputExpressionCalculatorException.class)
    public void testIncorrectIntegerOperation() {
        input = "sqrt 64 - sin 90";
        Validator validator = new IntegersValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, integersOperations);
    }
}