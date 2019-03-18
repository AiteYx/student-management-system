package com.hbsfdx.system.service.serviceImpl;

import com.google.gson.Gson;
import com.hbsfdx.system.Util.Json;
import com.hbsfdx.system.mapper.*;
import com.hbsfdx.system.pojo.*;
import com.hbsfdx.system.service.StudentService;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;
    @Resource
    ClassAndGradeMapper classAndGradeMapper;
    @Resource
    ClassScheduleMapper classScheduleMapper;
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    ClassCheckingInMapper classCheckingInMapper;
    @Resource
    ApplyMapper applyMapper;
    @Resource
    StudentEvaluationMapper studentEvaluationMapper;

    /**
     * 通过uerid和password查找 学生
     * @param userid
     * @param password
     * @return
     */
    @Override
    public Student findStuByUidAndPwd(String userid, String password) {

//        检查字符串是否含有非数字以外的
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(userid);
        if (!isNum.matches()) {
            return null;
        }

        StudentExample stuExample = new StudentExample();
        stuExample.createCriteria().andIdEqualTo(Long.parseLong(userid)).andPasswordEqualTo(password);
        List<Student> students = studentMapper.selectByExample(stuExample);
        if (students.size() == 1)   return students.get(0);
        else    return null;
    }

    /**
     * 通过classId查找 班级
     * @param classId
     * @return
     */
    @Override
    public ClassAndGrade findClzById(Long classId) {
        ClassAndGradeExample classAndGradeExample = new ClassAndGradeExample();
        classAndGradeExample.createCriteria().andIdEqualTo(classId);
        List<ClassAndGrade> clzs = classAndGradeMapper.selectByExample(classAndGradeExample);
        if (clzs.size() == 1) return clzs.get(0);
        return null;
    }

    /**
     * 通过classId查找课表，并返回。
     * @param clazId
     * @return
     */
    @Override
    public List<ClassSchedule> findClassScheduleByClassId(Long clazId) {

        ClassScheduleExample scheduleExample = new ClassScheduleExample();
        scheduleExample.createCriteria().andClassIdEqualTo(clazId);
        scheduleExample.setOrderByClause("week asc");
        List<ClassSchedule> classSchedules = classScheduleMapper.selectByExample(scheduleExample);
        return classSchedules;
    }

    /**
     * 通过id查找成绩
     * @param id
     * @return
     */
    @Override
    public List<Score> findScoreById(Long id) {

        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andStudentIdEqualTo(id);
        scoreExample.setOrderByClause("courseId asc");
        List<Score> scores = scoreMapper.selectByExample(scoreExample);
        return scores;
    }

    /**
     * 更新用户的email和tel
     * @param user
     * @param user_email
     * @param user_tele
     */
    @Override
    public boolean updateStudentEmailOrTelephone(Student user, String user_email, String user_tele) {

        if (!user_email.isEmpty()) user.setEmail(user_email);
        if (!user_tele.isEmpty())  user.setTelephone(user_tele);
        int i = studentMapper.updateByPrimaryKeySelective(user);
        if (i == 1) return true;
        return false;
    }

    /**
     * 按照班级查找学生
     * @param id
     * @return
     */
    @Override
    public List<Student> findStuByClassId(Long id) {

        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andClassIdEqualTo(id);
        studentExample.setOrderByClause("id asc");
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }

    /**
     * 通过 学期和学生id查找分数
     * @param term
     * @param id
     * @return
     */
    @Override
    public List<Score> findScoreByIdAndTerm(String term, Long id) {

        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andStudentIdEqualTo(id).andTermEqualTo(term);
        scoreExample.setOrderByClause("courseId asc");
        List<Score> scores = scoreMapper.selectByExample(scoreExample);
        return scores;
    }

    /**
     * 通过提交的消息，插入学生对应时间的考勤表，插入新记录
     *
     * @param term
     * @param week_times
     * @param week
     * @param cur_times
     * @param para
     * @return
     */
    @Override
    public int submitClassCheckingIn(String term, Long week_times, String week, String cur_times, String[] para){

        ClassCheckingIn classCheckingIn = new ClassCheckingIn();

        classCheckingIn.setTerm(term);
        classCheckingIn.setWeekTimes(week_times);
        classCheckingIn.setWeek(week);
        classCheckingIn.setCourseTime(cur_times);
        classCheckingIn.setStudentId(Long.valueOf(para[0]));
        classCheckingIn.setClassId(Long.valueOf(para[1]));
        classCheckingIn.setLate(0L);
        classCheckingIn.setAskForLeave(0L);
        classCheckingIn.setAbsenteeism(0L);
        //迟到 请假 旷课
        if ("late".equals(para[2])){
            classCheckingIn.setLate(1L);
        }else if ("leave".equals(para[2])){
            classCheckingIn.setAskForLeave(1L);
        }else {
            classCheckingIn.setAbsenteeism(1L);
        }

        return  classCheckingInMapper.insert(classCheckingIn);
    }

    /**
     * 更新学生头像
     * @param path
     * @param id
     * @param user_image
     */
    @Override
    public void changeHeadPortrait(String path, Long id, MultipartFile user_image) {

//        用学生id作为文件名字
        String fileName = String.valueOf(id);
//        获取上传的文件的名字，
        String user_imageName = user_image.getOriginalFilename();
        int n = user_imageName.lastIndexOf(".");
//        获取上传的文件的后缀
        String type = user_imageName.substring(n);
//        新建文件
        File targetFile = new File(path, fileName + type);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            user_image.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        更新数据库中头像的地址
        String url = "img/userHeadPortrait/" + fileName + type;
        Student student = new Student();
        student.setImage(url);
        student.setId(id);
        studentMapper.updateByPrimaryKeySelective(student);

    }

    /**
     * 查找指定学生的所有申请记录
     * @param id
     * @return
     */
    @Override
    public List<Apply> findApplyByStuId(Long id) {

        ApplyExample applyExample = new ApplyExample();
        applyExample.createCriteria().andStudentIdEqualTo(id);
        applyExample.setOrderByClause("date desc");
        return applyMapper.selectByExample(applyExample);
    }


    /**
     * 获取三种奖金的正在申请的人数
     * @return
     */
    @Override
    public long[] findBursarysNum() {

        long[] arr = new long[3];
        long l;
        ApplyExample applyExample = new ApplyExample();
        applyExample.createCriteria().andProjectNameEqualTo("国家励志奖学金").andResultEqualTo("正在审核");
        l = applyMapper.countByExample(applyExample);
        applyExample.clear();
        arr[0] = l;
        applyExample.createCriteria().andProjectNameEqualTo("校园励志奖学金").andResultEqualTo("正在审核");
        l = applyMapper.countByExample(applyExample);
        applyExample.clear();
        arr[1] = l;
        applyExample.createCriteria().andProjectNameEqualTo("国家助学金").andResultEqualTo("正在审核");
        l = applyMapper.countByExample(applyExample);
        arr[2] = l;
        return arr;
    }

    /**
     * 保存学生上传的文件，同时保存apply项
     * @param path
     * @param file
     * @param id
     * @param classId
     * @param date
     */
    @Override
    public void submitApplyFile(String path, MultipartFile file, Long id, Long classId, Date date) {

        // 保存学生上传的文件
        String fileName = String.valueOf(id) + date.getTime();
        int n = file.getOriginalFilename().lastIndexOf(".");
        String type = file.getOriginalFilename().substring(n);
        File targetFile = new File(path, fileName + type);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 保存该次申请   项目名 学生id 班级id 保存的文件的地址 审核情况 当前日期
        String fileUrl = "file/apply/studentFile/" + fileName + type;
        String proName = file.getOriginalFilename().substring(0, n - 3);
        Apply apply = new Apply();
        apply.setClassId(classId);
        apply.setDate(date);
        apply.setFileUrl(fileUrl);
        apply.setProjectName(proName);
        apply.setResult("正在审核");
        apply.setStudentId(id);
        applyMapper.insert(apply);
    }

    /**
     * 修改学生的密码
     * @param stu
     * @param newPassword
     * @return
     */
    @Override
    public int changeStuPassword(Student stu, String newPassword) {

        stu.setPassword(newPassword);
        return studentMapper.updateByPrimaryKeySelective(stu);
    }


    /**
     * 记录学生测评分数，加入数据库。
     *
     * @param stuId
     * @param classId
     * @param score
     * @param num
     */
    @Override
    public void stuAddEvaluation(Long stuId, Long classId, List<Long> score, long num) {


        StudentEvaluationExample example = new StudentEvaluationExample();
        example.createCriteria().andStudentIdEqualTo(stuId).andClassIdEqualTo(classId);
        List<StudentEvaluation> evaluations = studentEvaluationMapper.selectByExample(example);
        StudentEvaluation evaluation = null;
        if (evaluations.size()!=0){
            evaluation = evaluations.get(0);
            evaluation.setA1(evaluation.getA1() + score.get(0));
            evaluation.setA2(evaluation.getA2() + score.get(1));
            evaluation.setA3(evaluation.getA3() + score.get(2));
            evaluation.setA4(evaluation.getA4() + score.get(3));
            evaluation.setA5(evaluation.getA5() + score.get(4));
            evaluation.setA6(evaluation.getA6() + score.get(5));
            evaluation.result(num);
            studentEvaluationMapper.updateByExample(evaluation,example);
        }else {
            evaluation = new StudentEvaluation();
            evaluation.setStudentId(stuId);
            evaluation.setClassId(classId);
            evaluation.setA1(score.get(0));
            evaluation.setA2(score.get(1));
            evaluation.setA3(score.get(2));
            evaluation.setA4(score.get(3));
            evaluation.setA5(score.get(4));
            evaluation.setA6(score.get(5));
            evaluation.result(num);
            studentEvaluationMapper.insertSelective(evaluation);

        }
    }

    /**
     * 忘记密码
     * 检查用户的身份证，银行卡号是否正确，再修改密码。
     * @param userid
     * @param idCard
     * @param bankCard
     * @param password
     * @return
     */
    @Override
    public boolean checkAndChangePassword(String userid, String idCard, String bankCard, String password) {

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum1 = pattern.matcher(userid);
        Matcher isNum2 = pattern.matcher(idCard);
        Matcher isNum3 = pattern.matcher(bankCard);

        if (isNum1.matches() &&  isNum3.matches()) {

            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andIdEqualTo(Long.valueOf(userid));
            studentExample.createCriteria().andBankCardEqualTo(bankCard);
            studentExample.createCriteria().andIdCardEqualTo(idCard);
            List<Student> students = studentMapper.selectByExample(studentExample);
            if (students.size() == 1) {

                students.get(0).setPassword(password);
                studentMapper.updateByPrimaryKeySelective(students.get(0));
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 查找学生的考勤表，
     * 将  迟到  缺勤  请假 的记录封装json
     * 封装label的json
     * @param id
     * @return
     */
    @Override
    public String getStuCheckingInJson(Long id) {

        // 先查找到该学生的考勤列表
        ClassCheckingInExample classCheckingInExample = new ClassCheckingInExample();
        classCheckingInExample.createCriteria().andStudentIdEqualTo(id);
        List<ClassCheckingIn> stuCheckingIns = classCheckingInMapper.selectByExample(classCheckingInExample);

        List<String> labels = new ArrayList<>();
        List<Integer> datas = new ArrayList<>();
        labels.add("缺勤");
        labels.add("迟到");
        labels.add("请假");
        int i1 = 0, i2 = 0, i3 = 0;
        for (ClassCheckingIn c : stuCheckingIns) {

            if (c.getAbsenteeism() == 1L)   i1++;
            else if (c.getLate() == 1L) i2++;
            else    i3++;
        }
        datas.add(i1);
        datas.add(i2);
        datas.add(i3);

        List<Object> data = new ArrayList<>();
        data.add(labels);
        data.add(datas);

        return Json.toJson(data);

    }

    /**
     * 通过学生的id，获得学生最近的大考所有成绩，封装成json数据格式，返回给控制器
     * @param id
     * @return
     */
    @Override
    public String getStuLastExamScoreJson(Long id) {

        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andStudentIdEqualTo(id);
        scoreExample.setOrderByClause("term desc");
        List<Score> scores = scoreMapper.selectByExample(scoreExample);

        String term = null;
        List<String> labels = new ArrayList<>();
        List<Long> datas = new ArrayList<>();
        List<Object> data = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {

            Score s = scores.get(i);
            if (i == 0) term = s.getTerm();
            else {
                if (!term.equals(s.getTerm()))   break;
            }
            labels.add(s.getCourse());
            datas.add(s.getScore());
        }
        data.add(labels);
        data.add(datas);

        return Json.toJson(data);
    }

}
