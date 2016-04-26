import org.junit.Assert;
import static org.hamcrest.core.Is.is;

public class AdditionTest {

    @org.junit.Test
    public void testAddition() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(1.0);
        args.setSecondArg(5.5);
        double actual = new Addition(1).getResult(args);
        Assert.assertThat(actual, is(6.5));
    }

}