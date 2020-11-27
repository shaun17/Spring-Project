package sw.personal;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sw.personal.service.RedisLock;

import java.util.stream.IntStream;

@SpringBootApplication
public class RedisProjectApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);
	}

	private final  static Logger log = (Logger) LoggerFactory.getLogger(RedisProjectApplication.class);

	@Autowired
	RedisLock lock;

	@Override
	public void afterPropertiesSet() throws Exception {
		IntStream.rangeClosed(0,10).boxed().forEach(x->{
			lock.setK("key","value "+x.toString());
			log.info(lock.getV("key"));
		});
	}
}
