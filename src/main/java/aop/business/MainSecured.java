package aop.business;

import aop.business.SuperService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class MainSecured {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop");
        context.getBean(SuperService.class).doWork();
    }
}
