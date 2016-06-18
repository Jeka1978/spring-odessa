package aop;

import aop.business.DbService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop");
        try {
            context.getBean(DbService.class).doWork();
        } catch (Exception e) {
            System.out.println("PROBLEM");
        }try {
            context.getBean(DbService.class).doWork();
        } catch (Exception e) {
            System.out.println("PROBLEM");
        }
    }
}
