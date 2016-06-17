package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
    }
}
