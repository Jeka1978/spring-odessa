package mySpring;

import org.reflections.Reflections;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();
    private Reflections reflections = new Reflections("mySpring");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = reflections.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                try {
                    objectConfigurators.add(aClass.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Set<Class<? extends ProxyConfigurator>> proxyConfiguratorClasses = reflections.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> aClass : proxyConfiguratorClasses) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                try {
                    proxyConfigurators.add(aClass.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public <T> T createObject(Class<T> type) throws Exception {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        invokeInitMethod(t);
        t = configureProxy(t,type);

        return t;
    }



















    private <T> T configureProxy(T t, Class originalClass) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.wrapWithProxy(t,originalClass);
        }
        return t;
    }

    private <T> void invokeInitMethod(T t) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = t.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }


    private <T> void configure(T t) throws Exception {
        for (ObjectConfigurator objectConfigurator : objectConfigurators) {
            objectConfigurator.configure(t);
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        Class<T> returnType = type;
        if (type.isInterface()) {
            returnType = config.getImpl(type);
            if (returnType == null) {
                Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException("ifc " + type + " has 0 or more than one impl, please update your config");
                }
                returnType = (Class<T>) classes.iterator().next();
            }
        }
        return returnType;
    }
}






