package screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 18/06/2016.
 */
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(250,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void fly() {
        Random random = new Random();
        setLocation(random.nextInt(1200),random.nextInt(900));
        getContentPane().setBackground(getColorBean());
        repaint();
    }

    protected abstract Color getColorBean() ;
}









