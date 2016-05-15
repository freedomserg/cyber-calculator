import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CosTest {

    @Test
    public void testCos() {
        Cos cos = new Cos(4);
        DoubleArguments args = new DoubleArguments();
        args.setFirstArg(200.0);
        double result = cos.getResult(args);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        assertThat(actual, is(-0.94));
    }

}