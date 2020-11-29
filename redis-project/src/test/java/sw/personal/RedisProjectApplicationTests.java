package sw.personal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import sw.personal.service.RedisLock;

import java.util.UUID;

@SpringBootTest
class RedisProjectApplicationTests {

	@Autowired
	StringRedisTemplate template;
	@Autowired
	RedisLock lock;


	@Test
	public void redisLock() {
		String uuid = UUID.randomUUID().toString();
		boolean lock_key1 = lock.lockBlock("lock_key", uuid, 5000);
		System.out.println(lock_key1);
		boolean lock_key2 = lock.lockBlock("lock_key", uuid, 5000);
		System.out.println(lock_key2);

	}

}
