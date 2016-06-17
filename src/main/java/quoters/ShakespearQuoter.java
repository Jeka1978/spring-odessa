package quoters;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class ShakespearQuoter implements Quoter {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
