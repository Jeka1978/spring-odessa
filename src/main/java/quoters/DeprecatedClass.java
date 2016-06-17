package quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class value();
}

