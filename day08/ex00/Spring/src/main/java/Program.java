import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import printer.PrinterWithPrefixImpl;

public class Program {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        PrinterWithPrefixImpl printer = applicationContext.getBean("printer", PrinterWithPrefixImpl.class);

        printer.setPrefix("I Am PREFix");
        printer.print("Hello");

    }

}
