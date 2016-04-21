import java.util.Map;

public class ExecutedCalculatorOperations {
    private Map<String, Operation> operations;

    public ExecutedCalculatorOperations(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public void addOperation(String operationLiteral, Operation operation) {
        operations.put(operationLiteral, operation);
    }

    public Operation getOperation(String key) {
        return operations.get(key);
    }

    public boolean containsOperator(String key) {
        return operations.containsKey(key);
    }
}
