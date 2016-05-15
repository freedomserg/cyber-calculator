
public class CyberCalculator {

    private AbstractCalculator calculator;

    //setter-based injection
    public void setCalculator(AbstractCalculator calculator) {
        this.calculator = calculator;
    }

    //constructor-based injection
/*    public CyberCalculator(AbstractCalculator calculator) {
        this.calculator = calculator;
    }*/

    public String getResult(String expression) {
        return String.format("%.2f", evaluate(expression));
    }

    Object evaluate(String expression) {
        return calculator.evaluateExpression(expression);
    }
}
