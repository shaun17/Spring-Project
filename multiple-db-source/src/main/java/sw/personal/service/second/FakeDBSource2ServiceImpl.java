package sw.personal.service.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.personal.mapper.FakeDBSource2Mapper;

@Service
public class FakeDBSource2ServiceImpl {
    @Autowired
    FakeDBSource2Mapper mapper;

    public Object get(){
       return mapper.selectByExample(null);
    }
}
