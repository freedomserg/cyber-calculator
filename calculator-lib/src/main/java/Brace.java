import calculatorExceptions.UnsupportedOperationCalculatorException;

public class Brace extends Operation {

    public Brace(int priority) {
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
        if (true) throw new UnsupportedOperationCalculatorException();
        return 0;
    }

    @Override
    public long getResult(LongArguments arguments) {
        if (true) throw new UnsupportedOperationCalculatorException();
        return 0;
    }
}

