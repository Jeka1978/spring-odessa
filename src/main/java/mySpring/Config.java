package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public interface Config {
    <T> Class<T> getImpl(Class<T> type);
}
