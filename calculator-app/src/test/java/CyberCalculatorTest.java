import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.hamcrest.core.Is.is;

public class CyberCalculatorTest {
    private String infixNotation;
    private static CyberCalculator calculator;

    @BeforeClass
    public static void initCalculator() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        calculator = applicationContext.getBean("cyber-calculator", CyberCalculator.class);
    }

    @Test
    public void testWithkAllOperations() {
        infixNotation = "3 * 2.5 - 5 / 3.75 + 4 / 1.25 * 2.2";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(13.21));
    }

    @Test
    public void testkWithAllOperationsAndBrackets() {
        infixNotation = "6.54 * ( ( 22.25 - 8.95 ) / 4.2 * ( 99.87 - 31.94 ) ) * ( 1.9 - 3.12 )";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(-1716.33));
    }
}