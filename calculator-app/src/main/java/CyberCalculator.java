
public class CyberCalculator {

    private AbstractCalculator calculator;

    public void setCalculator(AbstractCalculator calculator) {
        this.calculator = calculator;
    }

    public String getResult(String expression) {
        return String.format("%.2f", evaluate(expression));
    }

    Object evaluate(String expression) {
        setCos();
        return calculator.evaluateExpression(expression);
    }

    private void setCos() {
        calculator.addNewOperation("cos", new Cos(4));
    }
}
