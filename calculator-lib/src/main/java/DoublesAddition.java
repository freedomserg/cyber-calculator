public class DoublesAddition extends BinaryOperation<Double> {

    public DoublesAddition(int priority) {
        super(priority);
    }

    @Override
    public Double getResult(Arguments<Double> arguments) {
        return arguments.firstArg + arguments.secondArg;
    }
}
