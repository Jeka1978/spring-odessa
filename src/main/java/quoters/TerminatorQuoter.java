package quoters;

import java.util.List;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
