package aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component
@Aspect
public class ExceptionHandlerAspect {
    @Value("${mails}")
    private String[] mails;

    private Map<DBException, Void> map = new WeakHashMap<>();

    @Pointcut("execution(* aop.business..*.*(..))")
    public void allBusinessMethods(){}

    @AfterThrowing(pointcut = "execution(* aop.business..*.*(..))",throwing = "ex")
    public void handleDbException(DBException ex) {
        if (!map.containsKey(ex)) {
            for (String mail : mails) {
                System.out.println("sending.. to "+mail+" "+ex.getMessage());
            }
            map.put(ex, null);

        }
    }
}
