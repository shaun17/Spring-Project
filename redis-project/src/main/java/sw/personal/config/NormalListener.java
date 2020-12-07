package sw.personal.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NormalListener implements ApplicationListener {
    Logger logger = LoggerFactory.getLogger(NormalEvent.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //当applicationpublish发布之后，在此接收
        logger.info("this is listener");
        //事件为NormalEvent，数据格式统一
        NormalEvent normalEvent = (NormalEvent) applicationEvent;
        System.out.println(normalEvent.getEventContent());
    }
}
