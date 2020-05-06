package main;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InputParserTest {

    InputParser classUnderTest = new InputParser();

    @Test
    public void shouldParseCorrectOperations() {
        assertEquals(OperationType.ADD, classUnderTest.parseOperation("ADD 1"));
        assertEquals(OperationType.SUBTRACT, classUnderTest.parseOperation("SUBTRACT 1"));
        assertEquals(OperationType.MULTIPLY, classUnderTest.parseOperation("MULTIPLY 1"));
        assertEquals(OperationType.DIVIDE, classUnderTest.parseOperation("DIVIDE 1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseInorrectOperations() {
        classUnderTest.parseOperation("ADD2 2");
    }

    @Test
    public void shouldParseOperationValue() {
        assertEquals(BigDecimal.ONE, classUnderTest.parseOperationValue("ADD 1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotParseInorrectOperationValue() {
        classUnderTest.parseOperationValue("ADD A33");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldNotParseOperationValueInputWithOneArgument() {
        classUnderTest.parseOperationValue("ADD2 ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowThreeArguments() {
        classUnderTest.validate("ADD 2 2");
    }
}