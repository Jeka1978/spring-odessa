package mySpring;

import javax.swing.*;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
