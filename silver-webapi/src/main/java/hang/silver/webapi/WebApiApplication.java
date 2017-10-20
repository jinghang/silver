package hang.silver.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "hang.silver") // 依赖注入扫描范围
@SpringBootApplication
public class WebApiApplication {
	public static void main(String[] args){
		SpringApplication.run(WebApiApplication.class, args);
	}
}
