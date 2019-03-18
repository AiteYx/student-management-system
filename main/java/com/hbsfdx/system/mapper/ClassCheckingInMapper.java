package com.hbsfdx.system.mapper;

import com.hbsfdx.system.pojo.ClassCheckingIn;
import com.hbsfdx.system.pojo.ClassCheckingInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassCheckingInMapper {
    long countByExample(ClassCheckingInExample example);

    int deleteByExample(ClassCheckingInExample example);

    int insert(ClassCheckingIn record);

    int insertSelective(ClassCheckingIn record);

    List<ClassCheckingIn> selectByExample(ClassCheckingInExample example);

    int updateByExampleSelective(@Param("record") ClassCheckingIn record, @Param("example") ClassCheckingInExample example);

    int updateByExample(@Param("record") ClassCheckingIn record, @Param("example") ClassCheckingInExample example);
}