package com.hbsfdx.system.mapper;

import com.hbsfdx.system.pojo.ClassMessage;
import com.hbsfdx.system.pojo.ClassMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassMessageMapper {
    long countByExample(ClassMessageExample example);

    int deleteByExample(ClassMessageExample example);

    int insert(ClassMessage record);

    int insertSelective(ClassMessage record);

    List<ClassMessage> selectByExample(ClassMessageExample example);

    int updateByExampleSelective(@Param("record") ClassMessage record, @Param("example") ClassMessageExample example);

    int updateByExample(@Param("record") ClassMessage record, @Param("example") ClassMessageExample example);
}