import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TanTest {

    @Test
    public void testTan() {
        Tan tan = new Tan(4);
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(45.0);
        double result = tan.getResult(args);
        double actual = new BigDecimal(result).setScale(1, RoundingMode.UP).doubleValue();
        assertThat(actual, is(1.0));
    }

}