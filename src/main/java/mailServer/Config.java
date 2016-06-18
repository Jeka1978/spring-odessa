package mailServer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 18/06/2016.
 */
@EnableScheduling
@Configuration
@ComponentScan(basePackages = "mailServer")
public class Config {
}
