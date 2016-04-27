
public class IntegersCalculator extends AbstractCalculator<Integer> {

    @Override
    protected void initConverter() {
        converter = new Converter(operations);
    }

    @Override
    protected void initValidator() {
        validator = new IntegersValidatorImpl();
    }

    @Override
    protected void addNumberToComputingStack(String number) {
        computingStack.push(Integer.valueOf(number));
    }

    @Override
    protected Integer executeOperation(String operationLiteral) {
        Operation operation = operations.getOperation(operationLiteral);
        IntegerArguments arguments = getArguments(operation);
        return operation.getResult(arguments);
    }

    @Override
    protected IntegerArguments getArguments(Operation operation) {
        IntegerArguments arguments = new IntegerArguments();
        if (operation instanceof BinaryOperation) {
            arguments.setSecondArg(computingStack.pop());
        }
        arguments.setFirstArg(computingStack.pop());
        return arguments;
    }
}
