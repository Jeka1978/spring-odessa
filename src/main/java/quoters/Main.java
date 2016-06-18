package quoters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println(context.getBean(Integer.class));
        System.out.println(context.getBean(Integer.class));
        System.out.println(context.getBean(Integer.class));
    }
}
