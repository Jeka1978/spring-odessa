package quoters;

import mySpring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class ShakespearQuoter implements Quoter {
    @Value("${shakespeare}")
    private String message;
    @InjectRandomInt(min = 4, max = 7)
    private int repeat;


    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
