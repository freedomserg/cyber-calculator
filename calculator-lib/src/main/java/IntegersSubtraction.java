public class IntegersSubtraction extends BinaryOperation<Integer> {

    public IntegersSubtraction(int priority) {
        super(priority);
    }

    @Override
    public Integer getResult(Arguments<Integer> arguments) {
        return arguments.firstArg - arguments.secondArg;
    }
}
