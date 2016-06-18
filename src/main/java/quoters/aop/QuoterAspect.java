package quoters.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component
@Aspect
public class QuoterAspect {
    @Before("execution(* quoters..*.say*(..))")
    public void printAuthor(JoinPoint jp){
        System.out.print("this is quote of: "+jp.getTarget().getClass().getSimpleName()+" ");
    }
}
