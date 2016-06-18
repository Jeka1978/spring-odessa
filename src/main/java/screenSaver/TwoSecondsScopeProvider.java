package screenSaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class TwoSecondsScopeProvider implements Scope {
    private Map<String, Pair<LocalDateTime,Object>> cache = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!cache.containsKey(name)|| ChronoUnit.SECONDS.between(cache.get(name).getKey(),LocalDateTime.now())>2) {
            cache.put(name, new Pair<>(LocalDateTime.now(),objectFactory.getObject()));
        }
        return cache.get(name).getValue();
    }























    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
