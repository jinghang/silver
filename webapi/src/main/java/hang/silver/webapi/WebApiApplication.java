package hang.silver.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = WebApiApplication.class)
@SpringBootApplication
public class WebApiApplication {
	public static void main(String[] args){
		SpringApplication.run(WebApiApplication.class, args);
	}
}
