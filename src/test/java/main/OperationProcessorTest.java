package main;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OperationProcessorTest {

    OperationProcessor operationProcessor = new OperationProcessor();

    @Test
    public void shouldExecuteAddOperation() {
        BigDecimal result = operationProcessor.executeOperation(BigDecimal.TEN, OperationType.ADD,
                                                                BigDecimal.valueOf(5L));
        assertEquals(BigDecimal.valueOf(15L), result);
    }

    @Test
    public void shouldExecuteSubtractOperation() {
        BigDecimal result = operationProcessor.executeOperation(BigDecimal.TEN, OperationType.SUBTRACT,
                BigDecimal.valueOf(5L));
        assertEquals(BigDecimal.valueOf(5L), result);
    }

    @Test
    public void shouldExecuteMultiplyOperation() {
        BigDecimal result = operationProcessor.executeOperation(BigDecimal.TEN, OperationType.MULTIPLY,
                BigDecimal.valueOf(5L));
        assertEquals(BigDecimal.valueOf(50L), result);
    }

    @Test
    public void shouldExecuteDivideOperation() {
        BigDecimal result = operationProcessor.executeOperation(BigDecimal.TEN, OperationType.DIVIDE,
                BigDecimal.valueOf(5L));
        assertEquals(BigDecimal.valueOf(2L), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowDivideByZero() {
        BigDecimal result = operationProcessor.executeOperation(BigDecimal.TEN, OperationType.DIVIDE,
                BigDecimal.ZERO);
        assertEquals(BigDecimal.valueOf(2L), result);
    }

}