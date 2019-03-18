package com.hbsfdx.system.service;

import com.hbsfdx.system.pojo.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface StudentService {

    Student findStuByUidAndPwd(String userid, String password);

    ClassAndGrade findClzById(Long classId);

    List<ClassSchedule> findClassScheduleByClassId(Long clazId);

    List<Score> findScoreById(Long id);

    boolean updateStudentEmailOrTelephone(Student user, String user_email, String user_tele);

    List<Student> findStuByClassId(Long id);

    List<Score> findScoreByIdAndTerm(String term, Long id);

    int submitClassCheckingIn(String term, Long week_times, String week, String cur_times, String[] split);

    void changeHeadPortrait(String path, Long id, MultipartFile user_image);

    List<Apply> findApplyByStuId(Long id);

    long[] findBursarysNum();

    void submitApplyFile(String path, MultipartFile file, Long id, Long classId, Date date);

    int changeStuPassword(Student stu, String newPassword);

    void stuAddEvaluation(Long stuId, Long classId, List<Long> score, long num);

    boolean checkAndChangePassword(String userid, String idCard, String bankCard, String password);

    String getStuCheckingInJson(Long id);

    String getStuLastExamScoreJson(Long id);
}
