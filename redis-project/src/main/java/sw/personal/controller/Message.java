package sw.personal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.personal.config.RedisEvent;

import java.util.UUID;

@RestController
public class Message {
    private final Logger log = LoggerFactory.getLogger(Hobby.class);
    public final static String messageId = UUID.randomUUID().toString().replace("-", "");

    @Autowired
    RedisTemplate redisTemplate;


    @GetMapping("push")
    public void push(String message){
        Long aLong = redisTemplate.opsForList().leftPush(messageId, message);
    }
    @GetMapping("pop")
    public Object pop(String message){
        Object o = redisTemplate.opsForList().rightPop(messageId);
        return o;
    }

}
