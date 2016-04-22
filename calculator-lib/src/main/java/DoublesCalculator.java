public class DoublesCalculator extends AbstractCalculator<Double> {

    @Override
    protected void initExecutedOperations() {
        operations = new ExecutedCalculatorOperations<>();
        operations.addOperation("+", new DoublesAddition(1));
        operations.addOperation("-", new DoublesSubtracting(1));
    }

    @Override
    protected void initConverter() {
        converter = new Converter<>(operations);
    }

    @Override
    protected void initValidator() {
        validator = new DoublesValidatorImpl();
    }

    @Override
    protected void addNumberToComputingStack(String number) {
        try {
            computingStack.push(Double.valueOf(number));
        } catch (NumberFormatException ex) {
            //throw new UnsupportedOperationCalculatorException();
            throw new RuntimeException();
        }
    }
}
