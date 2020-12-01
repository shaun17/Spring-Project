package sw.personal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
public class Hobby {

    private final Logger log = LoggerFactory.getLogger(Hobby.class);
    private final String userOne = UUID.randomUUID().toString().replace("-", "");
    private final String userTwo = UUID.randomUUID().toString().replace("-", "");

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("userOne")
    public Long userOne(String hobby) {
        return redisTemplate.opsForSet().add(userOne, hobby);
    }
    @GetMapping("userTwo")
    public Long userTwo(String hobby) {
        return redisTemplate.opsForSet().add(userTwo, hobby);
    }
    @GetMapping("dif")
    public void dif() {
        Set difference = redisTemplate.opsForSet().difference(userOne, userTwo);
        log.info(difference.toString());
        Set intersect = redisTemplate.opsForSet().intersect(userOne, userTwo);
        log.info(intersect.toString());
        Set union = redisTemplate.opsForSet().union(userOne, userTwo);
        log.info(union.toString());
    }

}
