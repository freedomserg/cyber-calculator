import java.util.HashMap;
import java.util.Map;

public class ExecutedCalculatorOperations<T> {
    private Map<String, Operation<T>> operations;

    public ExecutedCalculatorOperations() {
        this.operations = new HashMap<>();
        operations.put("(", new Brace(0));
        operations.put(")", new Brace(0));
    }

    public void addOperation(String operationLiteral, Operation<T> operation) {
        operations.put(operationLiteral, operation);
    }

    public Operation<T> getOperation(String key) {
        return operations.get(key);
    }

    public boolean containsOperation(String key) {
        return operations.containsKey(key);
    }
}
