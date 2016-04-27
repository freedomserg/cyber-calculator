import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquaringTest {

    private static Squaring sqr;

    @BeforeClass
    public static void initSquaring() {
        sqr = new Squaring(3);
    }

    @Test
    public void testIntegerSquaring() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(5);
        int actual = sqr.getResult(args);
        assertThat(actual, is(25));
    }

    @Test
    public void testLongSquaring() {
        LongArguments args = new LongArguments();
        args.setFirstArg(100L);
        long actual = sqr.getResult(args);
        assertThat(actual, is(10_000L));
    }

    @Test
    public void testDoubleSquaring() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(3.3);
        double result = sqr.getResult(args);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        assertThat(actual, is(10.89));
    }

    @Test
    public void testFloatSquaring() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(2.23f);
        float result = sqr.getResult(args);
        float actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).floatValue();
        assertThat(actual, is(4.97f));
    }
}