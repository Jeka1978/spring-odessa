package quoters;

import mySpring.Benchmark;
import mySpring.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Transactional
@Classic(century = 16)
public class TerminatorQuoter implements Quoter {
//    @Value("#{'${terminator}'.split(',')}")

    private List<String> messages;

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Value("")
    public void setMessages(@Value("${terminator}") String[] messages,@Value("${M2_HOME}") String maven) {
        System.out.println(maven);
        this.messages = Arrays.asList(messages);
    }

    @Override
    @Benchmark
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
