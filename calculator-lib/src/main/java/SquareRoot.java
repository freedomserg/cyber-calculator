public class SquareRoot extends UnaryOperation {

    public SquareRoot(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return Math.sqrt(arguments.getFirstArg());
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return (float) Math.sqrt(arguments.getFirstArg());
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return (int)Math.sqrt(arguments.getFirstArg());
    }

    @Override
    public long getResult(LongArguments arguments) {
        return (long)Math.sqrt(arguments.getFirstArg());
    }
}
