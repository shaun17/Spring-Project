package sw.personal;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sw.personal.mapper.LockTestMapper;
import sw.personal.po.LockTest;
import sw.personal.service.RedisLock;

import java.util.stream.IntStream;

@SpringBootApplication
@MapperScan("sw.personal.mapper")
public class RedisProjectApplication implements InitializingBean {

	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);
	}

	private final  static Logger log = (Logger) LoggerFactory.getLogger(RedisProjectApplication.class);

	@Autowired
	RedisLock lock;

	@Autowired
	LockTestMapper mapper;

	@Override
	public void afterPropertiesSet() {
		new Thread(()->{
			LockTest lockTest = mapper.selectByPrimaryKey(1);
			log.warn(JSONObject.toJSONString(lockTest));

		}).start();

		 new Thread(()->{
			LockTest lockTest = mapper.selectByPrimaryKey(1);
			log.warn(JSONObject.toJSONString(lockTest));
		}).start();

	}

	class Thread1 extends  Thread{
		@Override
		public void run() {
			super.run();
		}
	}
}
