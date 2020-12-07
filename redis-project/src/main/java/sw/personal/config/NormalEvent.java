package sw.personal.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * 只作为事件的承载体，不在生命周期内
 */
public class NormalEvent extends ApplicationEvent {
    Logger logger = LoggerFactory.getLogger(NormalEvent.class);
    private String eventContent;
    public NormalEvent(Object source) {
        super(source);
    }
    public NormalEvent(Object source, String eventContent) {
        super(source);
        this.eventContent=eventContent;
        logger.info("this is event");
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }
}
