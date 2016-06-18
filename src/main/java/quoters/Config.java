package quoters;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:user.properties")
@PropertySource("classpath:user.properties")
@PropertySource("classpath:user.properties")
@PropertySource("classpath:user.properties")
@PropertySource(value = "file:c:\\prod\\user.properties", ignoreResourceNotFound = true)
@ComponentScan(basePackages = "quoters")

public class Config {



}
