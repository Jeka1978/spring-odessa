package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
@Transactional
public class PowerCleaner implements Cleaner {

    @InjectRandomInt(min = 5, max = 8)
    private int repeat;

    @Override
    @Benchmark
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("FFFFFFFFFffffhhhhhhhhhhhhhh");
        }
    }
}
