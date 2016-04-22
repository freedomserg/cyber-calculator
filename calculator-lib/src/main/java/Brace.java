public class Brace extends Operation {

    public Brace(int priority) {
        super(priority);
    }

    @Override
    public Object getResult(Arguments arguments) {
        return new RuntimeException();
        //return UnsupportedOperationException();
    }
}
