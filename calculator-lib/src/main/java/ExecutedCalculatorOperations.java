import java.util.HashMap;
import java.util.Map;

public class ExecutedCalculatorOperations {
    private Map<String, Operation> operations;

    public ExecutedCalculatorOperations() {
        this.operations = new HashMap<>();
        operations.put("(", new Brace(0));
        operations.put(")", new Brace(0));
    }

    public void addOperation(String operator, Operation operation) {
        operations.put(operator, operation);
    }

    public Operation getOperation(String operator) {
        return operations.get(operator);
    }

    public boolean containsOperation(String operator) {
        return operations.containsKey(operator);
    }
}
