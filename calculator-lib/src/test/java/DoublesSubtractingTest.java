import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class DoublesSubtractingTest {

    @org.junit.Test
    public void testSubtracting() {
        Arguments<Double> args = new Arguments<>();
        args.firstArg = 7.25;
        args.secondArg = 6.25;
        double actual = new DoublesSubtracting(1).getResult(args);
        Assert.assertThat(actual, is(1.0));
    }

}