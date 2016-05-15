import calculatorExceptions.EmptyBracketsCalculatorException;
import calculatorExceptions.MismatchBracketsCalculatorException;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConverterTest {
    private String infixNotation;
    private static ExecutedCalculatorOperations doublesOperations;
    private static ExecutedCalculatorOperations integersOperations;

    @BeforeClass
    public static void initDoublesExecutedOperations() {
        doublesOperations = new ExecutedCalculatorOperations();
        doublesOperations.addOperation("+", new Addition(1));
        doublesOperations.addOperation("-", new Subtraction(1));
        doublesOperations.addOperation("*", new Multiplication(2));
        doublesOperations.addOperation("sqr", new Squaring(3));
        doublesOperations.addOperation("sqrt", new SquareRoot(3));
        doublesOperations.addOperation("ln", new NaturalLogarithm(3));
    }

    @BeforeClass
    public static void initIntegersExecutedOperations() {
        integersOperations = new ExecutedCalculatorOperations();
        integersOperations.addOperation("+", new Addition(1));
        integersOperations.addOperation("-", new Subtraction(1));
        integersOperations.addOperation("*", new Multiplication(2));
        integersOperations.addOperation("sqr", new Squaring(3));
        integersOperations.addOperation("sqrt", new SquareRoot(3));
        integersOperations.addOperation("ln", new NaturalLogarithm(3));
        integersOperations.addOperation("!", new Factorial(3));
    }

    @Test
    public void testConvertingWithAdditionOnDoubles() {
        infixNotation = "1.5 + 02.22";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("1.5", "02.22", "+");
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertingWithAdditionSubtractionBracesOnDoubles() {
        infixNotation = "5.197 - ( ( 74.1 - 11.33 ) + 125.48 )";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("5.197", "74.1", "11.33", "-", "125.48", "+", "-");
        assertEquals(expected, actual);
    }

    @Test(expected = EmptyBracketsCalculatorException.class)
    public void testEmptyBracketsException() {
        infixNotation = "1 + ( ) - 2";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
    }

    @Test
    public void testEnclosedExpression() {
        infixNotation = "( 3.3 + 8.2 )";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("3.3", "8.2", "+");
        assertEquals(expected, actual);
    }

    @Test(expected = MismatchBracketsCalculatorException.class)
    public void testMismatchBracketsException() {
        infixNotation = "( 1.9 - 2 + ( 45 - 12.6 )";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
    }

    @Test
    public void testFactorialOnIntegers() {
        infixNotation = "5 - 3 ! + ( 5 - 2 )";
        List<String> actual = new Converter(integersOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("5", "3", "!", "-", "5", "2", "-", "+");
        assertEquals(expected, actual);
    }

    @Test
    public void testFactorialWithSquaringOnIntegers() {
        infixNotation = "10 - sqr 4 ! - 15 + 2";
        List<String> actual = new Converter(integersOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("10", "4", "!", "sqr", "-", "15", "-", "2", "+");
        assertEquals(expected, actual);
    }

    @Test
    public void testNatLogarithmOnDoubles() {
        infixNotation = "25.5 - ln 75.5 + sqr 4.6";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("25.5", "75.5", "ln", "-", "4.6", "sqr", "+");
        assertEquals(expected, actual);
    }

    @Test
    public void testSqrtOnDoubles() {
        infixNotation = "18.66 - ( sqrt 116.9 + 13.3 )";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("18.66", "116.9", "sqrt", "13.3", "+", "-");
        assertEquals(expected, actual);
    }

    @Test
    public void testMultyplicationOnDoubles() {
        infixNotation = "2.5 + ( 10.0 * 1.5 )";
        List<String> actual = new Converter(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("2.5", "10.0", "1.5", "*", "+");
        assertEquals(expected, actual);
    }
}