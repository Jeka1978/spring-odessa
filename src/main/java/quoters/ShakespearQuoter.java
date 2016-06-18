package quoters;

import mySpring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Component
//@Classic(century = 16)
public class ShakespearQuoter implements Quoter {
    @Value("${shakespeare}")
    private String message;
    @InjectRandomInt(min = 4, max = 7)
    private int repeat;

    @Autowired
    private Lenin lenin;


    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
