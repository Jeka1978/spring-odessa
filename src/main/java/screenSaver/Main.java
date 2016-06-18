package screenSaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("screenSaver");
        while (true) {
            ColorFrame colorFrame = context.getBean(ColorFrame.class);
            colorFrame.fly();
            Thread.sleep(50);
        }
    }
}
