import org.hamcrest.core.Is;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

public class IntegersCalculatorTest {
    private String input;
    private List<String> postfixNotation;

    @Test
    public void testAdditionAndSubtraction() {
        input = "52 77 44 - + 65 -";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(20));
    }

    @Test
    public void testSquaring() {
        input = "3 4 sqr +";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(19));
    }

    @Test
    public void testSquareRoot() {
        input = "64 sqrt 12 -";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(-4));
    }

    @Test
    public void testNaturalLogarithm() {
        input = "15 ln 3 +";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(5));
    }

    @Test
    public void testFactorial() {
        input = "5 3 + 3 ! -";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(2));
    }

    @Test
    public void testMultiplication() {
        input = "2 3 *";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(6));
    }

    @Test
    public void testDivision() {
        input = "6 3 * 9 /";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(2));
    }

    @Test
    public void testPowering() {
        input = "5 4 + 3 ^";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(729));
    }

    @Test
    public void testRooting() {
        input = "64 6 root";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(2));
    }
}
