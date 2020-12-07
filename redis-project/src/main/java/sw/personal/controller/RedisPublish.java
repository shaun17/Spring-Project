package sw.personal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.personal.config.RedisReceiver;
import sw.personal.config.RedisTestEvent;

@RestController
public class RedisPublish implements ApplicationListener {
    private final Logger log = LoggerFactory.getLogger(RedisPublish.class);
   
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisReceiver redisReceiver;

    private ChannelTopic topic = new ChannelTopic("/redis/pubsub");

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        RedisTestEvent emailEvent = (RedisTestEvent)applicationEvent;
        log.info(emailEvent.getEventContent());
        log.info("application end");
    }

    @GetMapping("publish")
    public Object publish(){
        redisTemplate.convertAndSend(topic.getTopic(),"redisMessage yo yo yo");
        return null ;
    }





}

