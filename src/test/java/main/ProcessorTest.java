package main;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class ProcessorTest {

    private Processor classUnderTest = new Processor();

    // ((10 + 2) * 3) = 36
    @Test
    public void shouldCalculateResultCase1() {
        Queue<String> inputs = new LinkedList(Arrays.asList("add 2", "multiply 3", "apply 10"));
        assertEquals(BigDecimal.valueOf(36), classUnderTest.processOperations(inputs));
    }

    // ((10 * 3) + 2) = 32
    @Test
    public void shouldCalculateResultCase2() {
        Queue<String> inputs = new LinkedList(Arrays.asList("multiply 3", "add 2", "APPLY 10"));
        assertEquals(BigDecimal.valueOf(32), classUnderTest.processOperations(inputs));
    }

    // 1
    @Test
    public void shouldCalculateResultCase3() {
        Queue<String> inputs = new LinkedList(Arrays.asList("apply 1"));
        assertEquals(BigDecimal.ONE, classUnderTest.processOperations(inputs));
    }

}