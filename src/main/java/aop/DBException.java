package aop;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }
}
