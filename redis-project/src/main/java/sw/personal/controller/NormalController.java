package sw.personal.controller;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.personal.config.NormalEvent;

@RestController
public class NormalController {

    @Autowired
    ApplicationEventPublisher publisher;

    @GetMapping("pub")
    public Object pub(String str){
        //触发事件前 创建事件，封装好数据结构
        NormalEvent normalEvent = new NormalEvent(this,str);
        //然后通过application发布出去， 通过ApplicationListener接收
        publisher.publishEvent(normalEvent);
        return "success";
    }

}
