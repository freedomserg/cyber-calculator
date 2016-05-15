import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class DoublesCalculatorTest {
    private String input;
    private List<String> postfixNotation;

    @Test
    public void testAddition() {
        input = "11 22.0 + 0444.5 + 33.75 +";
        postfixNotation = Arrays.asList(input.split(" "));
        double actual = new DoublesCalculator().compute(postfixNotation);
        Assert.assertThat(actual, is(511.25));
    }


    @Test
    public void testSubtraction() {
        input = "75.2 33.7 12.555 - 12.95 - 14.75 - -";
        postfixNotation = Arrays.asList(input.split(" "));
        double actual = new DoublesCalculator().compute(postfixNotation);
        Assert.assertThat(actual, is(81.755));
    }

    @Test
    public void testSquaring() {
        input = "1.5 sqr";
        postfixNotation = Arrays.asList(input.split(" "));
        double actual = new DoublesCalculator().compute(postfixNotation);
        Assert.assertThat(actual, is(2.25));
    }

    @Test
    public void testSquareRoot() {
        input = "100.0 sqrt";
        postfixNotation = Arrays.asList(input.split(" "));
        double actual = new DoublesCalculator().compute(postfixNotation);
        Assert.assertThat(actual, is(10.0));
    }

    @Test
    public void testNaturalLogarithm() {
        input = "33.3 ln";
        postfixNotation = Arrays.asList(input.split(" "));
        double result = new DoublesCalculator().compute(postfixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(3.51));
    }

    @Test
    public void testMultiplication() {
        input = "2.5 2.0 *";
        postfixNotation = Arrays.asList(input.split(" "));
        double result = new DoublesCalculator().compute(postfixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(5.0));
    }
}