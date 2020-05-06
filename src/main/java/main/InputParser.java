package main;

import java.math.BigDecimal;

public class InputParser {

    public OperationType parseOperation(String input) {
        return OperationType.parse(input.toUpperCase().split(" ")[0]);
    }

    public BigDecimal parseOperationValue(String input) {
        String value = input.toUpperCase().split(" ")[1];
        try {
            return BigDecimal.valueOf(Long.parseLong(value));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("No numeric value to apply operation.");
        }
    }

    public void validate(String input) {
        validateArguments(input);
        if (isDivideByZeroOperation(input)) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
    }

    private void validateArguments(String input) {
        if (!containsTwoArguments(input)) {
            throw new IllegalArgumentException("Command should contain 2 arguments");
        }
        validateIsFirstArgumentAnOperation(input);
        validateIsSecondArgumentNumeric(input);
    }

    private boolean containsTwoArguments(String input) {
        return input.split(" ").length == 2;
    }

    private void validateIsFirstArgumentAnOperation(String input) {
        parseOperation(input);
    }

    private void validateIsSecondArgumentNumeric(String input) {
        parseOperationValue(input);
    }

    private boolean isDivideByZeroOperation(String input) {
        return OperationType.DIVIDE.equals(parseOperation(input)) && BigDecimal.ZERO.equals(parseOperationValue(input));
    }
}
