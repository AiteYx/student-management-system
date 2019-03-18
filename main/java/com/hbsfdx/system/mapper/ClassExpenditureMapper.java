package com.hbsfdx.system.mapper;

import com.hbsfdx.system.pojo.ClassExpenditure;
import com.hbsfdx.system.pojo.ClassExpenditureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassExpenditureMapper {
    long countByExample(ClassExpenditureExample example);

    int deleteByExample(ClassExpenditureExample example);

    int insert(ClassExpenditure record);

    int insertSelective(ClassExpenditure record);

    List<ClassExpenditure> selectByExample(ClassExpenditureExample example);

    int updateByExampleSelective(@Param("record") ClassExpenditure record, @Param("example") ClassExpenditureExample example);

    int updateByExample(@Param("record") ClassExpenditure record, @Param("example") ClassExpenditureExample example);
}