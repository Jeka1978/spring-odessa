package conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Service
public class MyService {
    @Autowired
    private Dao dao;

    @PostConstruct
    public void save(){
        dao.save();
    }
}
