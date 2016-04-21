public class DoublesSubtracting extends BinaryOperation<Double> {

    public DoublesSubtracting(int priority) {
        super(priority);
    }

    @Override
    public Double getResult(Arguments<Double> arguments) {
        return arguments.firstArg - arguments.secondArg;
    }
}
