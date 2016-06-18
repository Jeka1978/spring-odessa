package mailServer;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String getMessage(MailInfo mailInfo) {
        return "welcome "+mailInfo.getName();
    }
}
