import org.junit.Assert;
import static org.hamcrest.core.Is.is;

public class AdditionTest {

    @org.junit.Test
    public void testDoubleAddition() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(1.0);
        args.setSecondArg(5.5);
        double actual = new Addition(1).getResult(args);
        Assert.assertThat(actual, is(6.5));
    }

    @org.junit.Test
    public void testFloatAddition() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(3.85f);
        args.setSecondArg(10.55f);
        float actual = new Addition(1).getResult(args);
        Assert.assertThat(actual, is(14.4f));
    }

    @org.junit.Test
    public void testIntegerAddition() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(25);
        args.setSecondArg(10);
        int actual = new Addition(1).getResult(args);
        Assert.assertThat(actual, is(35));
    }

    @org.junit.Test
    public void testLongAddition() {
        LongArguments args = new LongArguments();
        args.setFirstArg(5_000_000_000L);
        args.setSecondArg(1_000_000_000L);
        long actual = new Addition(1).getResult(args);
        Assert.assertThat(actual, is(6_000_000_000L));
    }
}