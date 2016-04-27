public class NaturalLogarithm extends UnaryOperation {

    public NaturalLogarithm(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return Math.log(arguments.getFirstArg());
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return (float) Math.log(arguments.getFirstArg());
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return (int)Math.log(arguments.getFirstArg());
    }

    @Override
    public long getResult(LongArguments arguments) {
        return (long) Math.log(arguments.getFirstArg());
    }
}
