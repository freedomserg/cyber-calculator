import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RootingTest {

    private static Rooting root;

    @BeforeClass
    public static void initSquaring() {
        root = new Rooting(3);
    }

    @Test
    public void testIntegerRooting() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(729);
        args.setSecondArg(6);
        int actual = root.getResult(args);
        assertThat(actual, is(3));
    }

    @Test
    public void testLongRooting() {
        LongArguments args = new LongArguments();
        args.setFirstArg(20736L);
        args.setSecondArg(4L);
        long actual = root.getResult(args);
        assertThat(actual, is(12L));
    }

    @Test
    public void testDoubleRooting() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(100.0);
        args.setSecondArg(2.5);
        double result = root.getResult(args);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        assertThat(actual, is(6.30));
    }

    @Test
    public void testFloatRooting() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(20f);
        args.setSecondArg(3.5f);
        float result = root.getResult(args);
        float actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).floatValue();
        assertThat(actual, is(2.35f));
    }

}