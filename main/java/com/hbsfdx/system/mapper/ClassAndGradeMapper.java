package com.hbsfdx.system.mapper;

import com.hbsfdx.system.pojo.ClassAndGrade;
import com.hbsfdx.system.pojo.ClassAndGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassAndGradeMapper {
    long countByExample(ClassAndGradeExample example);

    int deleteByExample(ClassAndGradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassAndGrade record);

    int insertSelective(ClassAndGrade record);

    List<ClassAndGrade> selectByExample(ClassAndGradeExample example);

    ClassAndGrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassAndGrade record, @Param("example") ClassAndGradeExample example);

    int updateByExample(@Param("record") ClassAndGrade record, @Param("example") ClassAndGradeExample example);

    int updateByPrimaryKeySelective(ClassAndGrade record);

    int updateByPrimaryKey(ClassAndGrade record);
}