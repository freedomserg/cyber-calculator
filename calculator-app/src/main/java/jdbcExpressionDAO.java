import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class jdbcExpressionDAO implements ExpressionDAO {

    private String url = "jdbc:postgresql://localhost:5432/calculator";
    private String user = "user";
    private String password = "root";

    public void init() {
        loadDriver();
    }

    private void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find driver: org.postgresql.Driver");
        }
    }

    @Override
    public Map<String, String> getAll() {
        Map<String, String> evaluatedExpressions = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM evaluated_expressions");

            while (resultSet.next()) {
                String expression = resultSet.getString("expression");
                String result = resultSet.getString("result");
                evaluatedExpressions.put(expression, result);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Exception occurred while connecting to DB: " + url);
        }

        return evaluatedExpressions;
    }

    @Override
    public void write(String expression, String result) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO evaluated_expressions (expression, result) " +
                             "VALUES (?, ?)")) {
            statement.setString(1, expression);
            statement.setString(2, result);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Exception occurred while connecting to DB: " + url);
        }
    }
}
