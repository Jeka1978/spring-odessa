package quoters;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Component
public @interface Classic {
    int century();
}
