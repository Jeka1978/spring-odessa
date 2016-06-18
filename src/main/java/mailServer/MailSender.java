package mailServer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Service
public class MailSender {
    @Scheduled(cron = "1/2 * * * * ?")
    public void sendMail(){
        MailInfo mailInfo = DBUtils.getMailInfo();
        switch (mailInfo.getCode()) {
            case 1:
                //70 lines of code
                System.out.println("Welcome new clint mail was sent");
                break;
            default:
                //60 lines of code
                System.out.println("email callback was sent");
                break;
        }

    }
}
