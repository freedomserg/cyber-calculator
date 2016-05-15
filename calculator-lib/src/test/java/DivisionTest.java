import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class DivisionTest {

    @Test
    public void testIntegerDivision() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(3);
        args.setSecondArg(2);
        int actual = new Division(2).getResult(args);
        Assert.assertThat(actual, is(1));
    }

    @Test
    public void testLongDivision() {
        LongArguments args = new LongArguments();
        args.setFirstArg(1000L);
        args.setSecondArg(3L);
        long actual = new Division(2).getResult(args);
        Assert.assertThat(actual, is(333L));
    }

    @Test
    public void testDoubleDivision() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(15.5);
        args.setSecondArg(5.0);
        double actual = new Division(2).getResult(args);
        Assert.assertThat(actual, is(3.1));
    }

    @Test
    public void testFloatDivision() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(20.0f);
        args.setSecondArg(4.0f);
        float actual = new Division(2).getResult(args);
        Assert.assertThat(actual, is(5.0f));
    }

}
