package com.hbsfdx.system.mapper;

import com.hbsfdx.system.pojo.ClassSchedule;
import com.hbsfdx.system.pojo.ClassScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassScheduleMapper {
    long countByExample(ClassScheduleExample example);

    int deleteByExample(ClassScheduleExample example);

    int insert(ClassSchedule record);

    int insertSelective(ClassSchedule record);

    List<ClassSchedule> selectByExample(ClassScheduleExample example);

    int updateByExampleSelective(@Param("record") ClassSchedule record, @Param("example") ClassScheduleExample example);

    int updateByExample(@Param("record") ClassSchedule record, @Param("example") ClassScheduleExample example);
}