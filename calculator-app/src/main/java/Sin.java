public class Sin extends UnaryOperation {

    public Sin(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return Math.sin(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return (float) Math.sin(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return (int)Math.sin(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public long getResult(LongArguments arguments) {
        return (long)Math.sin(Math.toRadians(arguments.getFirstArg()));
    }
}
