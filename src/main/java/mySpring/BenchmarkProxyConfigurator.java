package mySpring;

import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object wrapWithProxy(Object t, Class type) {
        Method[] methods = type.getMethods();
        for (Method classMethod : methods) {
            if (classMethod.isAnnotationPresent(Benchmark.class)) {
                return Proxy.newProxyInstance(type.getClassLoader(), ClassUtils.getAllInterfacesForClass(type), (proxy, method, args) -> {
                    Method originalMethodFromClass = type.getMethod(method.getName(), method.getParameterTypes());
                    if (originalMethodFromClass.isAnnotationPresent(Benchmark.class)) {
                        System.out.println("***************BENCHMARK******************");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(t, args);
                        long after = System.nanoTime();
                        System.out.println("method: "+method.getName()+" was working for: "+(after-before));
                        System.out.println("***************BENCHMARK******************");
                        return retVal;
                    }else {
                        return method.invoke(t, args);
                    }
                });
            }
        }

        return t;
    }
}
