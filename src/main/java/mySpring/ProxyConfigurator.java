package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public interface ProxyConfigurator {
    Object wrapWithProxy(Object t, Class originalClass);
}
