import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NaturalLogarithmTest {
    private static NaturalLogarithm logarithm;

    @BeforeClass
    public static void initNaturalLog() {
        logarithm = new NaturalLogarithm(4);
    }

    @Test
    public void testIntegerNaturalLog() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(100);
        int actual = logarithm.getResult(args);
        assertThat(actual, is(4));
    }

    @Test
    public void testLongNaturalLog() {
        LongArguments args = new LongArguments();
        args.setFirstArg(5_000_000_000L);
        long actual = logarithm.getResult(args);
        assertThat(actual, is(22L));
    }

    @Test
    public void testDoubleNaturalLog() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(12.5);
        double result = logarithm.getResult(args);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        assertThat(actual, is(2.53));
    }

    @Test
    public void testFloatNaturalLog() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(37.66f);
        float result = logarithm.getResult(args);
        float actual = new BigDecimal(result).setScale(2, RoundingMode.UP).floatValue();
        assertThat(actual, is(3.63f));
    }
}