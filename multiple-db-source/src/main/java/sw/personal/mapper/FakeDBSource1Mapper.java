package sw.personal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sw.personal.po.FakeDBSource1;
import sw.personal.po.FakeDBSource1Example;

public interface FakeDBSource1Mapper {
    int countByExample(FakeDBSource1Example example);

    int deleteByExample(FakeDBSource1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(FakeDBSource1 record);

    int insertSelective(FakeDBSource1 record);

    List<FakeDBSource1> selectByExample(FakeDBSource1Example example);

    FakeDBSource1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FakeDBSource1 record, @Param("example") FakeDBSource1Example example);

    int updateByExample(@Param("record") FakeDBSource1 record, @Param("example") FakeDBSource1Example example);

    int updateByPrimaryKeySelective(FakeDBSource1 record);

    int updateByPrimaryKey(FakeDBSource1 record);
}