import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class MultiplicationTest {

    @Test
    public void testIntegerMultiplication() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(4);
        args.setSecondArg(7);
        int actual = new Multiplication(2).getResult(args);
        Assert.assertThat(actual, is(28));
    }

    @Test
    public void testLongMultiplication() {
        LongArguments args = new LongArguments();
        args.setFirstArg(40L);
        args.setSecondArg(2L);
        long actual = new Multiplication(2).getResult(args);
        Assert.assertThat(actual, is(80L));
    }

    @Test
    public void testDoubleMultiplication() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(2.5);
        args.setSecondArg(2.0);
        double actual = new Multiplication(2).getResult(args);
        Assert.assertThat(actual, is(5.0));
    }

    @Test
    public void testFloatMultiplication() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(3.3f);
        args.setSecondArg(2.2f);
        float actual = new Multiplication(2).getResult(args);
        Assert.assertThat(actual, is(7.26f));
    }
}