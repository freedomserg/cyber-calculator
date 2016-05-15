
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
        setSin();
        setTan();
        return calculator.evaluateExpression(expression);
    }

    private void setCos() {
        calculator.addNewOperation("cos", new Cos(4));
    }

    private void setSin() {
        calculator.addNewOperation("sin", new Sin(4));
    }

    private void setTan() {
        calculator.addNewOperation("tan", new Tan(4));
    }
}
