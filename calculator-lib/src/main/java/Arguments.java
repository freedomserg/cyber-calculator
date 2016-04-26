public abstract class Arguments<T> {
    private T firstArg;
    private T secondArg;

    public T getFirstArg() {
        return firstArg;
    }

    public T getSecondArg() {
        return secondArg;
    }

    public void setFirstArg(T firstArg) {
        this.firstArg = firstArg;
    }

    public void setSecondArg(T secondArg) {
        this.secondArg = secondArg;
    }
}
