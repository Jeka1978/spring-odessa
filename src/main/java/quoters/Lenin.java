package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component
public class Lenin {
    @Autowired
    private Lenin proxy;

    @Transactional(propagation = Propagation.REQUIRED)
    public void sayFignu() {
        System.out.println("U4itsa u4itsa...");
        proxy.sayDruguyuFignyu();
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sayDruguyuFignyu(){
        System.out.println("tovarichi!!!");
    }
}
