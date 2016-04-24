import CalculatorExceptions.EmptyBracketsCalculatorException;
import CalculatorExceptions.MismatchBracketsCalculatorException;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

public class ConverterTest {
    String infixNotation;
    static ExecutedCalculatorOperations<Double> doublesOperations;

    @BeforeClass
    public static void initDoublesExecutedOperations() {
        doublesOperations = new ExecutedCalculatorOperations<>();
        doublesOperations.addOperation("+", new DoublesAddition(1));
        doublesOperations.addOperation("-", new DoublesSubtraction(1));
    }

    @org.junit.Test
    public void testConvertingWithAdditionOnDoubles() {
        infixNotation = "1.5 + 02.22";
        List<String> actual = new Converter<>(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("1.5", "02.22", "+");
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testConvertingWithAdditionSubtractionBracesOnDoubles() {
        infixNotation = "5.197 - ( ( 74.1 - 11.33 ) + 125.48 )";
        List<String> actual = new Converter<>(doublesOperations).convertToPostfixNotation(infixNotation);
        List<String> expected = Arrays.asList("5.197", "74.1", "11.33", "-", "125.48", "+", "-");
        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test(expected = EmptyBracketsCalculatorException.class)
    public void testEmptyBracketsException() {
        infixNotation = "1 + ( ) - 2";
        List<String> actual = new Converter<>(doublesOperations).convertToPostfixNotation(infixNotation);
    }

    @org.junit.Test(expected = MismatchBracketsCalculatorException.class)
    public void testMismatchBracketsException() {
        infixNotation = "( 1.9 - 2 + ( 45 - 12.6 )";
        List<String> actual = new Converter<>(doublesOperations).convertToPostfixNotation(infixNotation);
    }


}