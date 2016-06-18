package conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Iterator;

/**
 * Created by Evegeny on 18/06/2016.
 */

public class OnDevCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Iterator<Object> annotationAttributes = metadata.getAnnotationAttributes(Dev.class.getName()).values().iterator();
        boolean windowsRequested = (boolean) annotationAttributes.next();
        boolean windowsDetected = false;
        String os = System.getenv().get("OS");
        if (os != null && os.toLowerCase().contains("windows")) {
            windowsDetected = true;
        }
        return (windowsRequested && windowsDetected) || (!windowsRequested && !windowsDetected);
    }
}
