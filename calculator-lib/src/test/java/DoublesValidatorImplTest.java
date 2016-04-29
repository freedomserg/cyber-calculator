import calculatorExceptions.InvalidInputExpressionCalculatorException;
import org.junit.*;

public class DoublesValidatorImplTest {
    private String input;
    static ExecutedCalculatorOperations doublesOperations;

    @BeforeClass
    public static void initDoublesExecutedOperations() {
        doublesOperations = new ExecutedCalculatorOperations();
        doublesOperations.addOperation("+", new Addition(1));
        doublesOperations.addOperation("-", new Subtraction(1));
        doublesOperations.addOperation("sqr", new Squaring(3));
        doublesOperations.addOperation("sqrt", new SquareRoot(3));
        doublesOperations.addOperation("ln", new NaturalLogarithm(3));
    }

    @Test
    public void testValidatorWithCorrectExpression() {
        input = "7.12 + 45.56 - ( 12.9 - 6.2 )";
        Validator validator = new DoublesValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, doublesOperations);
    }

    @Test(expected = InvalidInputExpressionCalculatorException.class)
    public void testValidatorWithIncorrectExpression() {
        input = "18,78 - 13.33? + { 16.75 - 6.1 }";
        Validator validator = new DoublesValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, doublesOperations);
    }

    @Test
    public void testValidateDoubleOperations() {
        input = "sqr 1.5 - ( sqrt 33.3 - ln 331.69 ) + 75.44";
        Validator validator = new DoublesValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, doublesOperations);
    }

    @Test(expected = InvalidInputExpressionCalculatorException.class)
    public void testIncorrectDoubleOperation() {
        input = "17.4 ! + sqr 3.3";
        Validator validator = new DoublesValidatorImpl();
        validator.validateExpressionAndCheckAcceptableOperations(input, doublesOperations);
    }
}