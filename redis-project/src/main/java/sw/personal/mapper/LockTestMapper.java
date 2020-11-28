package sw.personal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sw.personal.po.LockTest;
import sw.personal.po.LockTestExample;

public interface LockTestMapper {
    int countByExample(LockTestExample example);

    int deleteByExample(LockTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LockTest record);

    int insertSelective(LockTest record);

    List<LockTest> selectByExample(LockTestExample example);

    LockTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LockTest record, @Param("example") LockTestExample example);

    int updateByExample(@Param("record") LockTest record, @Param("example") LockTestExample example);

    int updateByPrimaryKeySelective(LockTest record);

    int updateByPrimaryKey(LockTest record);
}