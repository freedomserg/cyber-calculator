import org.junit.Assert;
import static org.hamcrest.core.Is.is;

public class DoublesAdditionTest {

    @org.junit.Test
    public void testAddition() {
        Arguments<Double> args = new Arguments<>();
        args.firstArg = 1.0;
        args.secondArg = 5.5;
        double actual = new DoublesAddition(1).getResult(args);
        Assert.assertThat(actual, is(6.5));
    }

}