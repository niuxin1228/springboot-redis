package cn.saytime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"com.uih.uplus"})
public class Application {
    public Application() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
