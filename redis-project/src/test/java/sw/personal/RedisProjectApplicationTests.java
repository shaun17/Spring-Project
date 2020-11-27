package sw.personal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisProjectApplicationTests {
	@Autowired
	StringRedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		Object key = redisTemplate.opsForValue().get("key");
		System.out.println(key.toString());
	}

}
