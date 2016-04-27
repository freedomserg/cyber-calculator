import calculatorExceptions.InvalidInputExpressionCalculatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class IntegersValidatorImpl implements Validator {
    public static final Pattern ONLY_DIGITS_PATTERN = Pattern.compile("^[0-9]+");

    @Override
    public void validateExpressionAndCheckAcceptableOperations(String inputExpression,
                                                               ExecutedCalculatorOperations operations) {
        String[] raw = inputExpression.split(" ");
        IntStream.range(0, raw.length).forEach(i -> {
            String word = raw[i];
            if (!operations.containsOperation(word)) {
                Matcher digitsMatcher = ONLY_DIGITS_PATTERN.matcher(word);
                if (!digitsMatcher.matches()) {
                    throw new InvalidInputExpressionCalculatorException();
                }
            }
        });
    }
}
