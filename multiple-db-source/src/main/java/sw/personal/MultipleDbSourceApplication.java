package sw.personal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("sw.personal.mapper")
@ComponentScan(basePackages = {"sw.personal.*"})
public class MultipleDbSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDbSourceApplication.class, args);
	}

}
