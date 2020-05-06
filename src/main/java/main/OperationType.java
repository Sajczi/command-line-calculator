package main;

public enum OperationType {

    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    APPLY;

    public static OperationType parse(String name) {
        try {
            return OperationType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown operation: " + name);
        }
    }
}
