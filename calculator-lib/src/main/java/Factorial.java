import calculatorExceptions.UnsupportedOperationCalculatorException;

public class Factorial extends UnaryOperation {

    public Factorial(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        if (true) throw new UnsupportedOperationCalculatorException();
        return 0;
    }

    @Override
    public float getResult(FloatArguments arguments) {
        if (true) throw new UnsupportedOperationCalculatorException();
        return 0;
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        int arg = arguments.getFirstArg();
        return getFact(arg);
    }

    private int getFact(int arg) {
        return arg == 1 ? arg : arg * getFact(arg - 1);
    }

    @Override
    public long getResult(LongArguments arguments) {
        long arg = arguments.getFirstArg();
        return getFact(arg);
    }

    private long getFact(long arg) {
        return arg == 1 ? arg : arg * getFact(arg - 1);
    }
}
