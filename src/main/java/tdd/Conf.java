package tdd;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Configuration
@ComponentScan(basePackages = "tdd")
public class Conf {

    @PostConstruct
    public void init(){
        System.out.println("CREATED");
    }
}
