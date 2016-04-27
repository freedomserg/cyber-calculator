public class Squaring extends UnaryOperation {

    public Squaring(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        double arg = arguments.getFirstArg();
        return arg * arg;
    }

    @Override
    public float getResult(FloatArguments arguments) {
        float arg = arguments.getFirstArg();
        return arg * arg;
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        int arg = arguments.getFirstArg();
        return arg * arg;
    }

    @Override
    public long getResult(LongArguments arguments) {
        long arg = arguments.getFirstArg();
        return arg * arg;
    }
}
