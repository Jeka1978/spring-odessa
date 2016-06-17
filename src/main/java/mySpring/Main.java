package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ObjectFactory factory = ObjectFactory.getInstance();
        IRobot iRobot = factory.createObject(IRobot.class);
        iRobot.cleanRoom();
        MyService myService = factory.createObject(MyService.class);
        myService.drinkBeer();
        myService.work();

    }
}
