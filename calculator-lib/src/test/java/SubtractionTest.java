import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class SubtractionTest {

    @org.junit.Test
    public void testSubtracting() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(7);
        args.setSecondArg(6);
        int actual = new Subtraction(1).getResult(args);
        Assert.assertThat(actual, is(1));
    }

}