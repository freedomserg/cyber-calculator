import calculatorExceptions.UnsupportedOperationCalculatorException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class FactorialTest {
    private static Factorial factorial;

    @BeforeClass
    public static void initFactorial() {
        factorial = new Factorial(4);
    }

    @Test
    public void testIntegerFactorial() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(5);
        int actual = factorial.getResult(args);
        Assert.assertThat(actual, is(120));
    }

    @Test
    public void testLongFactorial() {
        LongArguments args = new LongArguments();
        args.setFirstArg(10L);
        long actual = factorial.getResult(args);
        Assert.assertThat(actual, is(3628800L));
    }

    @Test(expected = UnsupportedOperationCalculatorException.class)
    public void testDoubleFactorial() {
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(9.0);
        double actual = factorial.getResult(args);
    }

    @Test(expected = UnsupportedOperationCalculatorException.class)
    public void testFloatFactorial() {
        FloatArguments args = new FloatArguments();
        args.setFirstArg(25f);
        float actual = factorial.getResult(args);
    }
}