package sw.personal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.personal.config.RedisEvent;
import sw.personal.config.RedisReceiver;

@RestController
public class PublishListener implements ApplicationListener {
    private final Logger log = LoggerFactory.getLogger(PublishListener.class);
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisReceiver redisReceiver;
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        RedisEvent emailEvent = (RedisEvent)applicationEvent;
        log.info(emailEvent.getEventContent());
    }

    @GetMapping("publish")
    public Object publish( String channel ){
        redisTemplate.convertAndSend(channel,"redisMessage");
        String message =(String) redisTemplate.opsForValue().get("redisMessage");
        return message ;
    }
}
