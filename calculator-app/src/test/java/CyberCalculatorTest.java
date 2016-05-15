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
    public void testAddition() {
        infixNotation = "3.0 + 5";
        double actual = (double)calculator.evaluate(infixNotation);
        Assert.assertThat(actual, is(8.0));
    }

    @Test
    public void testSubtraction() {
        infixNotation = "17.3 - 5.6";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(11.7));
    }

    @Test
    public void testAdditionAndSubtractionWithBrackets() {
        infixNotation = "5.0 - ( 3.1 - 1.6 ) + 2.4";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(5.9));
    }

    @Test
    public void testMultiplication() {
        infixNotation = "2.0 * 3.0";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(6.0));
    }

    @Test
    public void testDivision() {
        infixNotation = "8.5 / 1.5";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(5.67));
    }

    @Test
    public void testAdditSubtrMultiplDivOperations() {
        infixNotation = "3 * 2.5 - 5 / 3.75 + 4 / 1.25 * 2.2";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(13.21));
    }

    @Test
    public void testAdditSubtrMultiplDivOperationsAndBrackets() {
        infixNotation = "6.54 * ( ( 22.25 - 8.95 ) / 4.2 * ( 99.87 - 31.94 ) ) * ( 1.9 - 3.12 )";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(-1716.33));
    }

    @Test
    public void testSquaring() {
        infixNotation = "sqr 2.0";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(4.0));
    }

    @Test
    public void testSquareRoot() {
        infixNotation = "sqrt 2.25";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(1.5));
    }

    @Test
    public void testNaturalLogarithm() {
        infixNotation = "ln 50.78";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(3.93));
    }

    @Test
    public void testComplexExpression() {
        infixNotation = "ln 12.25 / ( sqrt 125.66 - sqr 2.9 * 3.74 )";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(3, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(-0.124));
    }

    @Test
    public void testAnotherComplexExpression() {
        infixNotation = "2 * 3 + ( sqr 2.0 * sqrt 2.25 ) / ln 10 - 9.3 ^ ( 4.6 root 2.7 )";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(-42.01));
    }

    @Test
    public void testEnclosedExpression() {
        infixNotation = "( sqr 2.0 * sqrt 2.25 )";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(1, RoundingMode.DOWN).doubleValue();
        Assert.assertThat(actual, is(6.0));
    }

    @Test
    public void testCos() {
        infixNotation = "cos 75";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(0.26));
    }

    @Test
    public void testSin() {
        infixNotation = "sin 175";
        double result = (double)calculator.evaluate(infixNotation);
        double actual = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        Assert.assertThat(actual, is(0.09));
    }
}