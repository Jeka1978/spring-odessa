package tdd;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Component
public class Calc {
    public int sum(int a, int b) {
        return a + b;
    }
}
