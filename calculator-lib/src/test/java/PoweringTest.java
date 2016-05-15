import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PoweringTest {

    private static Powering pwr;

    @BeforeClass
    public static void initSquaring() {
        pwr = new Powering(3);
    }

    @Test
    public void testIntegerPowering() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(2);
        args.setSecondArg(3);
        int actual = pwr.getResult(args);
        assertThat(actual, is(8));
    }

    @Test
    public void testLongPowering() {
        LongArguments args = new LongArguments();
        args.setFirstArg(4L);
        args.setSecondArg(3L);
        long actual = pwr.getResult(args);
        assertThat(actual, is(64L));
    }

    @Test
    public void testDoublePowering() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(7.0);
        args.setSecondArg(1.5);
        double result = pwr.getResult(args);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        assertThat(actual, is(18.52));
    }

    @Test
    public void testFloatPowering() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(2.0f);
        args.setSecondArg(2.5f);
        float result = pwr.getResult(args);
        float actual = new BigDecimal(result).setScale(2, RoundingMode.UP).floatValue();
        assertThat(actual, is(5.66f));
    }

}