package sw.personal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLock {

    @Autowired
    StringRedisTemplate redisTemplate;

    public void setK(String k, String v){
        redisTemplate.opsForValue().set(k, v);
    }

    public String getV(String k){
        return redisTemplate.opsForValue().get(k);
    }
}
