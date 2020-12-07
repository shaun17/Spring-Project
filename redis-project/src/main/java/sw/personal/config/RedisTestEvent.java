package sw.personal.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AppConfigurationEntry;

public class RedisTestEvent extends ApplicationEvent {
    private String eventContent;
    public RedisTestEvent(Object source) {
        super(source);
    }
    public RedisTestEvent(Object source, String eventContent){
        super(source);
        this.eventContent = eventContent;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }
}
