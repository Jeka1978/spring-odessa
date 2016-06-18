package aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Service
public class DbService {
    @Autowired
    private Dao dao;

    public void doWork(){
        System.out.println("woring...");
        dao.save();
    }
}
