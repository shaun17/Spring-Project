package sw.personal.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisReceiver implements MessageListener {
    private final Logger logger = LoggerFactory.getLogger(RedisReceiver.class);

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        logger.info("redis 收到message:{}",new String(message.getBody()));
        RedisTestEvent event = new RedisTestEvent(this,new String(message.getBody()));
        publisher.publishEvent(event);
    }
}
