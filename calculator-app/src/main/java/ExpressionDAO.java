import java.util.Map;

public interface ExpressionDAO {

    Map<String, String> getAll();

    void write(String expression, String result);
}
