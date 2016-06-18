package mailServer;

import java.util.Random;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class DBUtils {
    public static MailInfo getMailInfo() {
        Random random = new Random();
        return new MailInfo(random.nextInt(2) + 1);

    }
}
