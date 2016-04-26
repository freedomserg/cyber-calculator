public abstract class Operation {
    private int priority;

    public Operation(int priority) {
        this.priority = priority;
    }

    public abstract double getResult(DoubleArguments arguments);
    public abstract float getResult(FloatArguments arguments);
    public abstract int getResult(IntegerArguments arguments);
    public abstract long getResult(LongArguments arguments);

    public int getPriority() {
        return priority;
    }
}


