package sw.personal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sw.personal.po.FakeDBSource2;
import sw.personal.po.FakeDBSource2Example;

public interface FakeDBSource2Mapper {
    int countByExample(FakeDBSource2Example example);

    int deleteByExample(FakeDBSource2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(FakeDBSource2 record);

    int insertSelective(FakeDBSource2 record);

    List<FakeDBSource2> selectByExample(FakeDBSource2Example example);

    FakeDBSource2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FakeDBSource2 record, @Param("example") FakeDBSource2Example example);

    int updateByExample(@Param("record") FakeDBSource2 record, @Param("example") FakeDBSource2Example example);

    int updateByPrimaryKeySelective(FakeDBSource2 record);

    int updateByPrimaryKey(FakeDBSource2 record);
}