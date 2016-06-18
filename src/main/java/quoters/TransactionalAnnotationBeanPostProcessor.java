package quoters;

import mySpring.Transactional;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Component
public class TransactionalAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Transactional.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if (beanClass!=null) {
            if (beanClass.getInterfaces().length == 0) {
                return Enhancer.create(beanClass, (InvocationHandler) (o, method, args) ->{
                    System.out.println("*************TRANSACTION OPENED****************");
                    Object retVal = method.invoke(bean, args);
                    System.out.println("*************TRANSACTION COMMITED****************");
                    return retVal;
                });
            }
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),(proxy, method, args) -> {
                System.out.println("*************TRANSACTION OPENED****************");
                Object retVal = method.invoke(bean, args);
                System.out.println("*************TRANSACTION COMMITED****************");
                return retVal;
            });
        }
        return bean;
    }
}
