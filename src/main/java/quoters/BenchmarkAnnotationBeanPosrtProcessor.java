package quoters;

import mySpring.Benchmark;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Component
public class BenchmarkAnnotationBeanPosrtProcessor implements BeanPostProcessor {



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (Method classMethod : methods) {
            if (classMethod.isAnnotationPresent(Benchmark.class)) {
                return Proxy.newProxyInstance(beanClass.getClassLoader(), ClassUtils.getAllInterfacesForClass(beanClass), (proxy, method, args) -> {
                    Method originalMethodFromClass = beanClass.getMethod(method.getName(), method.getParameterTypes());
                    if (originalMethodFromClass.isAnnotationPresent(Benchmark.class)) {
                        System.out.println("***************BENCHMARK******************");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        System.out.println("method: "+method.getName()+" was working for: "+(after-before));
                        System.out.println("***************BENCHMARK******************");
                        return retVal;
                    }else {
                        return method.invoke(bean, args);
                    }
                });
            }
        }

        return bean;
    }
}
