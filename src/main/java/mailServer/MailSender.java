package mailServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Service
public class MailSender {

    @Autowired
    private Map<String, MailGenerator> map;

    @Scheduled(cron = "1/2 * * * * ?")
    public void sendMail(){
        MailInfo mailInfo = DBUtils.getMailInfo();
        String code = String.valueOf(mailInfo.getCode());
        MailGenerator mailGenerator = map.get(code);
        if (mailGenerator == null) {
            throw new RuntimeException("code " + code + " not supported yet");
        }
        String message = mailGenerator.getMessage(mailInfo);
        send(message);
    }

    private void send(String message) {
        System.out.println("message = " + message);
    }
}














