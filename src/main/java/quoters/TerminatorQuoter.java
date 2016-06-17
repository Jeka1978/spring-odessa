package quoters;

import mySpring.Benchmark;
import mySpring.Transactional;

import java.util.List;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Transactional
@DeprecatedClass(T1000.class)
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    @Benchmark
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
