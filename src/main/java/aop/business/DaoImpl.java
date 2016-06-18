package aop.business;

import aop.DBException;
import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Repository
public class DaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("saving...");
        throw new DBException("fire all DBA!!!");
    }
}
