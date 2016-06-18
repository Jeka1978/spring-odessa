package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component
@Aspect
public class SecurityAspect {


    @Around("@annotation(aop.business.Secured)")
    public Object doSecured(ProceedingJoinPoint pjp) throws Throwable {
        Random random = new Random();
        if (random.nextInt(3) == 2) {
            throw new RuntimeException("not allowed here, try again...");
        }else {
            return pjp.proceed();
        }
    }
}
