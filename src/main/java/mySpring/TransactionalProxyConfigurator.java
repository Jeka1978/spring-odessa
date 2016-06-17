package mySpring;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class TransactionalProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object wrapWithProxy(Object t, Class type) {
        if (type.isAnnotationPresent(Transactional.class)) {
            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, (InvocationHandler) (o, method, args) ->{
                    System.out.println("*************TRANSACTION OPENED****************");
                    Object retVal = method.invoke(t, args);
                    System.out.println("*************TRANSACTION COMMITED****************");
                    return retVal;
                });
            }
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(),(proxy, method, args) -> {
                System.out.println("*************TRANSACTION OPENED****************");
                Object retVal = method.invoke(t, args);
                System.out.println("*************TRANSACTION COMMITED****************");
                return retVal;
            });
        }
        return t;
    }
}
