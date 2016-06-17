package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    public <T> T createObject(Class<T> type) throws Exception {
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        T t = type.newInstance();


        return t;
    }
}
