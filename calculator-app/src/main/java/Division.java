import calculatorExceptions.DivisionByZeroCalculatorException;

public class Division extends BinaryOperation {

    public Division(int priority) {
        super(priority);
    }

    @Override
    public double getResult(DoubleArguments arguments) {
        if (arguments.getSecondArg() == 0) throw new DivisionByZeroCalculatorException();
        return arguments.getFirstArg() / arguments.getSecondArg();
    }

    @Override
    public float getResult(FloatArguments arguments) {
        if (arguments.getSecondArg() == 0) throw new DivisionByZeroCalculatorException();
        return arguments.getFirstArg() / arguments.getSecondArg();
    }

    @Override
    public int getResult(IntegerArguments arguments) {
        if (arguments.getSecondArg() == 0) throw new DivisionByZeroCalculatorException();
        return arguments.getFirstArg() / arguments.getSecondArg();
    }

    @Override
    public long getResult(LongArguments arguments) {
        if (arguments.getSecondArg() == 0) throw new DivisionByZeroCalculatorException();
        return arguments.getFirstArg() / arguments.getSecondArg();
    }
}