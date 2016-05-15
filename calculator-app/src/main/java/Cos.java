public class Cos extends UnaryOperation {

    public Cos(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return Math.cos(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return (float) Math.cos(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return (int)Math.cos(Math.toRadians(arguments.getFirstArg()));
    }

    @Override
    public long getResult(LongArguments arguments) {
        return (long)Math.cos(Math.toRadians(arguments.getFirstArg()));
    }
}
