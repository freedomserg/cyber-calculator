import CalculatorExceptions.UnsupportedOperationCalculatorException;

public class BraceTest {

    @org.junit.Test(expected = UnsupportedOperationCalculatorException.class)
    public void testBrace() {
        IntegerArguments args = new IntegerArguments();
        args.setFirstArg(25);
        args.setSecondArg(10);
        new Brace(0).getResult(args);
    }

}