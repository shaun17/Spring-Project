package sw.personal.service.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.personal.mapper.FakeDBSource1Mapper;

@Service
public class FakeDBSource1ServiceImpl {
    @Autowired
    FakeDBSource1Mapper mapper;

    public Object get(){
       return mapper.selectByExample(null);
    }
}
