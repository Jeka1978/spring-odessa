package quoters;

import mySpring.InjectRandomInt;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class ShakespearQuoter implements Quoter {
    private String message;
    @InjectRandomInt(min = 4, max = 7)
    private int repeat;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
