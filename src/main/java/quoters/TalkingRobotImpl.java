package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Component

public class TalkingRobotImpl implements TalkingRobot {

    @Autowired(required = false)
//    @Classic(century = 16)
    private List<Quoter> quoters = new ArrayList<>(Arrays.asList(new Quoter() {
        @Override
        public void sayQuote() {
            System.out.println("This is default quote");
        }
    }));

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }


    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
