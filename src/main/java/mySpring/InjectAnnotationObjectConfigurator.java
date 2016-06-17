package mySpring;

import java.lang.reflect.Field;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class InjectAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    public void configure(Object o) throws Exception {
        Class<?> type = o.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                ObjectFactory factory = ObjectFactory.getInstance();
                Object object = factory.createObject(field.getType());
                field.setAccessible(true);
                field.set(o,object);
            }
        }
    }
}
