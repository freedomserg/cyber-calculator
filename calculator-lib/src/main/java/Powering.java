public class Powering extends BinaryOperation {

    public Powering(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        return Math.pow(arguments.getFirstArg(), arguments.getSecondArg());
    }

    @Override
    public float getResult(FloatArguments arguments) {
        return (float) Math.pow(arguments.getFirstArg(), arguments.getSecondArg());
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        return (int)Math.pow(arguments.getFirstArg(), arguments.getSecondArg());
    }

    @Override
    public long getResult(LongArguments arguments) {
        return (long)Math.pow(arguments.getFirstArg(), arguments.getSecondArg());
    }
}
