public class DoublesCalculator extends AbstractCalculator<Double> {

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
        computingStack.push(Double.valueOf(number));
    }

    @Override
    protected Double executeOperation(String operationLiteral) {
        Operation operation = operations.getOperation(operationLiteral);
        DoubleArguments arguments = getArguments(operation);
        return operation.getResult(arguments);
    }

    @Override
    protected DoubleArguments getArguments(Operation operation) {
        DoubleArguments arguments = new DoubleArguments();
        if (operation instanceof BinaryOperation) {
            arguments.setSecondArg(computingStack.pop());
        }
        arguments.setFirstArg(computingStack.pop());
        return arguments;
    }
}
