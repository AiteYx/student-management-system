package com.hbsfdx.system.service.serviceImpl;

import com.hbsfdx.system.mapper.ClassAndGradeMapper;
import com.hbsfdx.system.mapper.TeacherMapper;
import com.hbsfdx.system.pojo.*;
import com.hbsfdx.system.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;
    @Resource
    ClassAndGradeMapper classAndGradeMapper;
    /**
     * 通过uerid和password查找 教师
     * @param userid
     * @param password
     * @return
     */
    @Override
    public Teacher findTeaByUidAndPwd(String userid, String password) {

        TeacherExample teaExample = new TeacherExample();
        teaExample.createCriteria().andIdEqualTo(Long.parseLong(userid));
        teaExample.createCriteria().andPasswordEqualTo(password);
        List<Teacher> teachers = teacherMapper.selectByExample(teaExample);
        if (teachers.size() == 1)   return teachers.get(0);
        else    return null;
    }

    @Override
    public ClassAndGrade findClzById(Long classId) {

        ClassAndGradeExample classAndGradeExample = new ClassAndGradeExample();
        classAndGradeExample.createCriteria().andIdEqualTo(classId);
        List<ClassAndGrade> clzs = classAndGradeMapper.selectByExample(classAndGradeExample);
        return clzs.get(0);
    }
}
