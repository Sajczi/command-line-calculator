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
            throw new IllegalArgumentException("No numeric value to apply operation.")
        }
    }

    public void validate(String input) {
        parseOperation(input);
        parseOperationValue(input);
        if (isDivideByZeroOperation(input)) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
    }

    private boolean isDivideByZeroOperation(String input) {
        return OperationType.DIVIDE.equals(parseOperation(input)) && BigDecimal.ZERO.equals(parseOperationValue(input));
    }
}
