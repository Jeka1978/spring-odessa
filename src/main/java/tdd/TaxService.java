package tdd;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component
public class TaxService {
    @PostConstruct
    public void init(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(123);
    }

    public int getTax() {

        return 20;
    }
}
