package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class IRobot {
    private Speaker speaker;
    private Cleaner cleaner;

    public IRobot() throws Exception {
        speaker = ObjectFactory.getInstance().createObject(Speaker.class);
        cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);
    }

    public void cleanRoom() {
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}
