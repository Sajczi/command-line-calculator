package main;

import java.math.BigDecimal;
import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        Queue<String> commandList = getInputFromUser();
        BigDecimal result = new Processor().processOperations(commandList);
        System.out.println("The result is: " + result);
    }

    private static Queue<String> getInputFromUser() {
        InputParser inputParser = new InputParser();
        Queue<String> commandList = new LinkedList();
        Scanner in = new Scanner(System.in);
        OperationType operation = OperationType.ADD;
        String input;

        do {
            input = in.nextLine();
            try {
                inputParser.validate(input);
                operation = inputParser.parseOperation(input);
                commandList.add(input);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while(!operation.equals(OperationType.APPLY));
        return commandList;
    }
}
