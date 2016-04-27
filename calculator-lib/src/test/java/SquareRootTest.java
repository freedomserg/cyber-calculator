import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareRootTest {
    private static SquareRoot sqrt;

    @BeforeClass
    public static void initSquareRoot() {
        sqrt = new SquareRoot(3);
    }

    @Test
    public void testIntegerSquareRoot() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(100);
        int actual = sqrt.getResult(args);
        assertThat(actual, is(10));
    }

    @Test
    public void testLongSquareRoot() {
        LongArguments args = new LongArguments();
        args.setFirstArg(64L);
        long actual = sqrt.getResult(args);
        assertThat(actual, is(8L));
    }

    @Test
    public void testDoubleSquareRoot() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(2.78);
        double result = sqrt.getResult(args);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        assertThat(actual, is(1.67));
    }

    @Test
    public void testFloatSquareRoot() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(43f);
        float result = sqrt.getResult(args);
        float actual = new BigDecimal(result).setScale(2, RoundingMode.UP).floatValue();
        assertThat(actual, is(6.56f));
    }
}