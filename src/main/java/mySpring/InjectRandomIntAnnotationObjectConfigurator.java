package mySpring;

import org.springframework.core.annotation.Order;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Order(1)
public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    public void configure(Object t) throws Exception {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int randomNum = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(t,randomNum);
            }
        }
    }
}
