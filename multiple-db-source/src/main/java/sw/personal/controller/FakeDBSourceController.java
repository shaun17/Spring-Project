package sw.personal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.personal.service.primary.FakeDBSource1ServiceImpl;
import sw.personal.service.second.FakeDBSource2ServiceImpl;

@RestController
public class FakeDBSourceController {
    @Autowired
    FakeDBSource1ServiceImpl db1;
    @Autowired
    FakeDBSource2ServiceImpl db2;

    @GetMapping("db1")
    public Object getDB1(){
        return db1.get();
    }
    @GetMapping("db2")
    public Object getDB2(){
        return db2.get();
    }
}
