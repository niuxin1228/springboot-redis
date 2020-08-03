package cn.saytime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//扫描bean来调包
@ComponentScan(basePackages = {"com.uih.uplus.common","cn.saytime"})
public class SpringbootCrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrosApplication.class, args);
	}

}
