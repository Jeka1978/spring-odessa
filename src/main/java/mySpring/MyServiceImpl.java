package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class MyServiceImpl implements MyService {
    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Жигулёвское");
    }
}
