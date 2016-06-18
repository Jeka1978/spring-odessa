package conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnDevCondition.class)
public @interface Dev {
    boolean value();
}
