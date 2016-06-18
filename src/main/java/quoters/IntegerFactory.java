package quoters;

import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

/**
 * Created by Evegeny on 18/06/2016.
 */
public class IntegerFactory implements FactoryBean<Integer> {
    private Random random = new Random();
    private int max;

    public IntegerFactory(int max) {
        this.max = max;
    }

    public int getRandomInt() {
        return random.nextInt(max);
    }

    @Override
    public Integer getObject() throws Exception {
        return getRandomInt();
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}





