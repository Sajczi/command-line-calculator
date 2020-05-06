package main;

import java.math.BigDecimal;

public class OperationProcessor {

    public BigDecimal executeOperation(BigDecimal currentResult, OperationType operationType, BigDecimal input) {
        switch(operationType) {
            case ADD:
                currentResult = currentResult.add(input);
                break;
            case SUBTRACT:
                currentResult = currentResult.subtract(input);
                break;
            case MULTIPLY:
                currentResult = currentResult.multiply(input);
                break;
            case DIVIDE:
                if(input.equals(BigDecimal.ZERO)) {
                    throw new IllegalArgumentException("Cannot divide by zero!");
                }
                currentResult = currentResult.divide(input);
                break;
        }
        return currentResult;
    }

}
