package aop.business;

import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Service
public class SuperService {
    @Secured
    public void doWork(){
        System.out.println("bla bla");
    }
}
