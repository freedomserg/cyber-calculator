import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Bootstrap {

    private ExpressionDAO expressionDAO;

    public void setExpressionDAO(ExpressionDAO expressionDAO) {
        this.expressionDAO = expressionDAO;
    }

    public ExpressionDAO getExpressionDAO() {
        return expressionDAO;
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml",
                "aop-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
        CyberCalculator cyberCalculator = applicationContext.getBean("cyber-calculator", CyberCalculator.class);
        bootstrap.execute(cyberCalculator);
    }

    private void execute(CyberCalculator cyberCalculator) throws IOException {
        IOUtil.printToConsole("Please, enter an expression to evaluate: ");
        String expression = IOUtil.getExpression();
        String result = cyberCalculator.getResult(expression);
        getExpressionDAO().write(expression, result);
        IOUtil.printToConsole(expression);
        IOUtil.printEqualSign();
        IOUtil.printToConsole(result);
    }
}
