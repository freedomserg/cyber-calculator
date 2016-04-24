import CalculatorExceptions.UnsupportedOperationCalculatorException;

public class IntegersCalculator extends AbstractCalculator<Integer> {
    @Override
    protected void initExecutedOperations() {
        operations = new ExecutedCalculatorOperations<>();
        operations.addOperation("+", new IntegersAddition(1));
        operations.addOperation("-", new IntegersSubtraction(1));
    }

    @Override
    protected void initConverter() {
        converter = new Converter<>(operations);
    }

    @Override
    protected void initValidator() {
        validator = new IntegersValidatorImpl();
    }

    @Override
    protected void addNumberToComputingStack(String number) {
        computingStack.push(Integer.valueOf(number));
    }
}
