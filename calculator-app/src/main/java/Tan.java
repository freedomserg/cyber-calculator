public class Tan extends UnaryOperation {

    public Tan(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return Math.tan(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return (float) Math.tan(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return (int)Math.tan(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public long getResult(LongArguments arguments) {
        return (long)Math.tan(Math.toRadians(arguments.getFirstArg()));
    }
}
