import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtil {

    public static String getExpression() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static void printToConsole(String text) {
        System.out.print(text);
    }

    public static String getEqualSign() {
        return " = ";
    }
}
