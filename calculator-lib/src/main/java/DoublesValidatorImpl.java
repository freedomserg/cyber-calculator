import calculatorExceptions.InvalidInputExpressionCalculatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class DoublesValidatorImpl implements Validator {
    public static final Pattern ONLY_DIGITS_PATTERN = Pattern.compile("^[0-9]+");
    public static final Pattern DOUBLES_PATTERN = Pattern.compile("-?[0-9]+.?[0-9]*");

    @Override
    public void validateExpressionAndCheckAcceptableOperations(String inputExpression,
                                                               ExecutedCalculatorOperations operations) {
        String[] raw = inputExpression.split(" ");
        IntStream.range(0, raw.length).forEach(i -> {
            String word = raw[i];
            if (operations.containsOperation(word)) {
                return;
            }
            Matcher digitsMatcher = ONLY_DIGITS_PATTERN.matcher(word);
            if (digitsMatcher.matches()) {
                return;
            }
            Matcher doublesMatcher = DOUBLES_PATTERN.matcher(word);
            if (doublesMatcher.matches()) {
                return;
            }
            throw new InvalidInputExpressionCalculatorException();
        });
    }
}
