public class IntegersAddition extends BinaryOperation<Integer> {

    public IntegersAddition(int priority) {
        super(priority);
    }

    @Override
    public Integer getResult(Arguments<Integer> arguments) {
        return arguments.firstArg + arguments.secondArg;
    }
}
