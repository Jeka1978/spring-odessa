package mailServer;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component("2")
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String getMessage(MailInfo mailInfo) {
        return "sorry " + mailInfo.getName() + " we will call you asap";
    }
}
