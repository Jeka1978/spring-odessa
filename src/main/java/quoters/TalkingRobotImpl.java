package quoters;

import java.util.List;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
