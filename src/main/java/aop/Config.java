package aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:user.properties")
public class Config {

}
