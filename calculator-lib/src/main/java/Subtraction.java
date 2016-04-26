public class Subtraction extends BinaryOperation {

    public Subtraction(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return arguments.getFirstArg() - arguments.getSecondArg();
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return arguments.getFirstArg() - arguments.getSecondArg();
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return arguments.getFirstArg() - arguments.getSecondArg();
    }

    @Override
    public long getResult(LongArguments arguments) {
        return arguments.getFirstArg() - arguments.getSecondArg();
    }
}
