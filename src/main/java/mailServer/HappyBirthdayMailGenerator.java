package mailServer;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component("3")
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String getMessage(MailInfo mailInfo) {
        return "Happy birthday " + mailInfo.getName();
    }
}
