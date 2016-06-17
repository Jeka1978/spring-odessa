package mySpring;

/**
 * Created by Evegeny on 17/06/2016.
 */
public class BenchmarkCleaner implements Cleaner {
    @Inject
    private PowerCleaner powerCleaner;


    @Override
    public void clean() {
        long before = System.nanoTime();
        powerCleaner.clean();
        long after = System.nanoTime();
        System.out.println(after-before);
    }
}
