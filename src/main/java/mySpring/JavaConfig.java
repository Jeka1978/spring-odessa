package mySpring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class JavaConfig implements Config {
    private Map<Class, Class> ifc2Class = new HashMap<>();

    public JavaConfig() {
        ifc2Class.put(Speaker.class, ConsoleSpeaker.class);
        ifc2Class.put(Cleaner.class, PowerCleaner.class);
    }

    public <T> Class<T> getImpl(Class<T> type) {
        return ifc2Class.get(type);
    }
}
