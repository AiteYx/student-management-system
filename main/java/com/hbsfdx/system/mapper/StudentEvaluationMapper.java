package com.hbsfdx.system.mapper;

import com.hbsfdx.system.pojo.StudentEvaluation;
import com.hbsfdx.system.pojo.StudentEvaluationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentEvaluationMapper {
    long countByExample(StudentEvaluationExample example);

    int deleteByExample(StudentEvaluationExample example);

    int deleteByPrimaryKey(Long studentId);

    int insert(StudentEvaluation record);

    int insertSelective(StudentEvaluation record);

    List<StudentEvaluation> selectByExample(StudentEvaluationExample example);

    StudentEvaluation selectByPrimaryKey(Long studentId);

    int updateByExampleSelective(@Param("record") StudentEvaluation record, @Param("example") StudentEvaluationExample example);

    int updateByExample(@Param("record") StudentEvaluation record, @Param("example") StudentEvaluationExample example);

    int updateByPrimaryKeySelective(StudentEvaluation record);

    int updateByPrimaryKey(StudentEvaluation record);
}