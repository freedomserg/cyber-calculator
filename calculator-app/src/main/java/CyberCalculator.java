import org.springframework.beans.factory.annotation.Autowired;

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

    public String evaluate(String expression) {
        return calculator.evaluateExpression(expression).toString();
    }

    public void addOperation() {

    }
}
