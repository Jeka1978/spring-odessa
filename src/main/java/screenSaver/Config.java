package screenSaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 18/06/2016.
 */
@Configuration
@ImportResource("classpath:context.xml")
public class Config {

    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            protected Color getColorBean() {
                return randomColor();
            }
        };
    }
    @Bean
    @Scope(value = "prototype")
    public Color randomColor() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
