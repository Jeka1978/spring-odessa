package mySpring;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Transactional
public class IRobot {
    @Inject
    private Speaker speaker;
    @Inject
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}
