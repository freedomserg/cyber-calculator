import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml",
                "aop-context.xml");
        CyberCalculator cyberCalculator = applicationContext.getBean("cyber-calculator", CyberCalculator.class);
        IOUtil.printToConsole("Please, enter an expression to evaluate: ");
        String expression = IOUtil.getExpression();
        String result = cyberCalculator.getResult(expression);
        IOUtil.printToConsole(expression);
        IOUtil.printEqualSign();
        IOUtil.printToConsole(result);
    }
}
