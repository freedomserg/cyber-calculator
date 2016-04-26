import java.util.HashMap;
import java.util.Map;

public class ExecutedCalculatorOperations {
    private Map<String, Operation> operations;

    public ExecutedCalculatorOperations() {
        this.operations = new HashMap<>();
        operations.put("(", new Brace(0));
        operations.put(")", new Brace(0));
    }

    public void addOperation(String operationLiteral, Operation operation) {
        operations.put(operationLiteral, operation);
    }

    public Operation getOperation(String keyLiteral) {
        return operations.get(keyLiteral);
    }

    public boolean containsOperation(String keyLiteral) {
        return operations.containsKey(keyLiteral);
    }
}
