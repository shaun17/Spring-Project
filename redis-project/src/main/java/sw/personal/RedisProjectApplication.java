package sw.personal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "sw.personal")
@MapperScan("sw.personal.mapper")
public class RedisProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);
	}


}
