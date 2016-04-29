import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class SubtractionTest {

    @Test
    public void testIntegerSubtracting() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(7);
        args.setSecondArg(6);
        int actual = new Subtraction(1).getResult(args);
        Assert.assertThat(actual, is(1));
    }

    @Test
    public void testLongSubtracting() {
        LongArguments args = new LongArguments();
        args.setFirstArg(7_000_000_000L);
        args.setSecondArg(6_000_000_000L);
        long actual = new Subtraction(1).getResult(args);
        Assert.assertThat(actual, is(1_000_000_000L));
    }

    @Test
    public void testDoubleSubtracting() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(20.5);
        args.setSecondArg(13.5);
        double actual = new Subtraction(1).getResult(args);
        Assert.assertThat(actual, is(7.0));
    }

    @Test
    public void testFloatSubtracting() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(10.0f);
        args.setSecondArg(9.5f);
        float actual = new Subtraction(1).getResult(args);
        Assert.assertThat(actual, is(0.5f));
    }
}