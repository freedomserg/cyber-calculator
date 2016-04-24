public class DoublesSubtraction extends BinaryOperation<Double> {

    public DoublesSubtraction(int priority) {
        super(priority);
    }

    @Override
    public Double getResult(Arguments<Double> arguments) {
        return arguments.firstArg - arguments.secondArg;
    }
}
