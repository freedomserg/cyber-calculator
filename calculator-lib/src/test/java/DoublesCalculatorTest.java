import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class DoublesCalculatorTest {
    private String input;
    private List<String> postfixNotation;

    @org.junit.Test
    public void testAdditionOnDoubles() {
        input = "11 22.0 + 0444.5 + 33.75 +";
        postfixNotation = Arrays.asList(input.split(" "));
        double actual = new DoublesCalculator().compute(postfixNotation);
        Assert.assertThat(actual, is(511.25));
    }

    @org.junit.Test
    public void testSubtractionOnDoubles() {
        input = "75.2 33.7 12.555 - 12.95 - 14.75 - -";
        postfixNotation = Arrays.asList(input.split(" "));
        double actual = new DoublesCalculator().compute(postfixNotation);
        Assert.assertThat(actual, is(81.755));
    }

}