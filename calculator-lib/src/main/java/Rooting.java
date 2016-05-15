public class Rooting extends BinaryOperation {

    public Rooting(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return Math.pow(arguments.getFirstArg(), 1 / arguments.getSecondArg());
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return (float) Math.pow(arguments.getFirstArg(), 1 / arguments.getSecondArg());
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return (int)Math.pow(arguments.getFirstArg(), 1 / (double)arguments.getSecondArg());
    }

    @Override
    public long getResult(LongArguments arguments) {
        return (long)Math.pow(arguments.getFirstArg(), 1 / (double)arguments.getSecondArg());
    }
}
