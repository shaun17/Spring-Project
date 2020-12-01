package sw.personal.config;

import org.springframework.context.ApplicationEvent;

import javax.security.auth.login.AppConfigurationEntry;

public class RedisEvent extends ApplicationEvent {
    private String eventContent;
    public RedisEvent(Object source) {
        super(source);
    }
    public RedisEvent(Object source, String eventContent){
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
