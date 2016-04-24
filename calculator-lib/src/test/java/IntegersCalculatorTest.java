import org.hamcrest.core.Is;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

public class IntegersCalculatorTest {
    private String input;
    private List<String> postfixNotation;

    @org.junit.Test
    public void testAdditionAndSubtractionOnIntegers() {
        input = "52 77 44 - + 65 -";
        postfixNotation = Arrays.asList(input.split(" "));
        int actual = new IntegersCalculator().compute(postfixNotation);
        Assert.assertThat(actual, Is.is(20));
    }
}
