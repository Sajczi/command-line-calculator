package main;

import java.math.BigDecimal;
import java.util.Queue;

public class Processor {

    private final OperationProcessor operationProcessor = new OperationProcessor();
    private final InputParser inputParser = new InputParser();

    public BigDecimal processOperations(Queue<String> inputs) {
        BigDecimal initialValue = inputParser.parseOperationValue(getApplyInput(inputs));
        BigDecimal result = initialValue;
        do {
            String input = inputs.poll();
            result = operationProcessor.executeOperation(result, inputParser.parseOperation(input),
                    inputParser.parseOperationValue(input));
        } while (!inputs.isEmpty());
        return result;
    }

    public String getApplyInput(Queue<String> inputs) {
        return inputs.stream().filter(input -> OperationType.APPLY.equals(inputParser.parseOperation(input))).findFirst().get();
    }
}
