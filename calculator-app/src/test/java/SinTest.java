import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SinTest {

    @Test
    public void testSin() {
        Sin sin = new Sin(4);
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(25.0);
        double result = sin.getResult(args);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        assertThat(actual, is(0.42));
    }

}