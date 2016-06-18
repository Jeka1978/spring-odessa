package mailServer;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Random;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class DBUtils {
    public static MailInfo getMailInfo() {
        Random random = new Random();
        DataFactory dataFactory = new DataFactory();
        return new MailInfo(random.nextInt(3) + 1,dataFactory.getName());

    }
}
