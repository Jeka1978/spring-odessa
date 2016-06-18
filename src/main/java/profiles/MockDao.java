package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Repository
@Profile("DEV")
public class MockDao implements Dao {
    @Override
    public void save() {
        System.out.println("Lanisters always payed debts");
    }
}
