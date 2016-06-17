package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Benchmark
public class PowerCleaner implements Cleaner {

    @InjectRandomInt(min = 5, max = 8)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("FFFFFFFFFffffhhhhhhhhhhhhhh");
        }
    }
}
