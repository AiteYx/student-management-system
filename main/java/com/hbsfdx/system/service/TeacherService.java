package com.hbsfdx.system.service;

import com.hbsfdx.system.pojo.ClassAndGrade;
import com.hbsfdx.system.pojo.Teacher;

public interface TeacherService {


    Teacher findTeaByUidAndPwd(String userid, String password);

    ClassAndGrade findClzById(Long classId);
}
