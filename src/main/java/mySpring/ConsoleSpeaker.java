package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Transactional
public class ConsoleSpeaker implements Speaker {
    public void speak(String message) {
        System.out.println(message);
    }
}
