public abstract class Operation <T> {
    private int priority;

    public Operation(int priority) {
        this.priority = priority;
    }

    public abstract T getResult(Arguments<T> arguments);

    public int getPriority() {
        return priority;
    }
}


