package com.hbsfdx.system.service.serviceImpl;

import com.google.gson.Gson;
import com.hbsfdx.system.Util.FormatConversion;
import com.hbsfdx.system.Util.Json;
import com.hbsfdx.system.mapper.*;
import com.hbsfdx.system.pojo.*;
import com.hbsfdx.system.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    ClassExpenditureMapper classExpenditureMapper;
    @Resource
    ClassMessageMapper classMessageMapper;
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    ClassScheduleMapper classScheduleMapper;
    @Resource
    ClassCheckingInMapper classCheckingInMapper;

    /**
     * 通过班级id查找班级财务记录
     * @param id
     * @return
     */
    @Override
    public String classFinancialAjax(Long id) {

        ClassExpenditureExample classExpenditureExample = new ClassExpenditureExample();
        classExpenditureExample.createCriteria().andClassIdEqualTo(id);
        classExpenditureExample.setOrderByClause("updated asc");
        List<ClassExpenditure> classExpenditures = classExpenditureMapper.selectByExample(classExpenditureExample);

        List<Long> data = new ArrayList<>();
        List<Long> lab = new ArrayList<>();
        int i = 0;
        for (ClassExpenditure classExpenditure: classExpenditures) {

            if (lab.contains(classExpenditure.getWeekTimes()))  continue;
            lab.add(classExpenditure.getWeekTimes());
        }

        for (Long l: lab) {
            Long sum = 0L;
            for (ClassExpenditure classExpenditure: classExpenditures) {
                if (classExpenditure.getWeekTimes() == l) {
                    sum += classExpenditure.getAmount();
                }
            }
            data.add(sum);
        }

        List<Object> list = new ArrayList<>();
        list.add(data);
        list.add(lab);
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /**
     * 通过班级id查找班级消息
     * @param id
     * @return
     */
    @Override
    public List<ClassMessage> findClassMessage(Long id) {

        ClassMessageExample classMessageExample = new ClassMessageExample();
        classMessageExample.createCriteria().andClassIdEqualTo(id);
        classMessageExample.setOrderByClause("updated desc");
        List<ClassMessage> classMessages = classMessageMapper.selectByExample(classMessageExample);
        return classMessages;
    }

    /**
     * 通过班级id和课程id，获得了班级指定课程的平均值
     * @param courseId
     * @param classId
     * @param term
     * @return
     */
    @Override
    public Double findAveScoreByClassIdAndCourseId(Long courseId, Long classId, String term) {

//        查找出来求总和，再除去数组大小

        ScoreExample scoreExample = new ScoreExample();
        scoreExample.createCriteria().andClassIdEqualTo(classId).andCourseidEqualTo(courseId).andTermEqualTo(term);
        List<Score> scores = scoreMapper.selectByExample(scoreExample);
        int n = scores.size();
        int sum = 0;
        for (Score s: scores) {
            sum += s.getScore();
        }
        if (n != 0) return Double.valueOf(sum / n);
        return null;
    }

    /**
     * 添加消息到数据库中
     * @param local
     * @param time
     * @param msgContext
     * @param id
     * @return
     */
    @Override
    public boolean addMessage(String local, String time, String msgContext, Long id) {

        ClassMessage classMessage = new ClassMessage();
        classMessage.setClassId(id);
        classMessage.setContent(msgContext);
        classMessage.setLocation(local);
        try {
            classMessage.setUpdated(FormatConversion.StringToDate(time));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        classMessageMapper.insert(classMessage);
        return true;
    }

    /**
     * 获取指定课程的名字
     * @param s
     * @param week
     * @param clazId
     * @param cur_times
     * @return
     */
    @Override
    public String findClassScheduleJsonName(String s, long week, long clazId, String cur_times)  {

        ClassScheduleExample classScheduleExample = new ClassScheduleExample();
        classScheduleExample.createCriteria().andWeekEqualTo(week).andClassIdEqualTo(clazId).andWeekTimesEqualTo(s);
        List<ClassSchedule> classSchedules = classScheduleMapper.selectByExample(classScheduleExample);

        Gson gson = new Gson();
        switch (cur_times) {

            case "am1":
                return gson.toJson(classSchedules.get(0).getAm1());
            case "am2":
                return gson.toJson(classSchedules.get(0).getAm2());
            case "pm1":
                return gson.toJson(classSchedules.get(0).getPm1());
            default:
                return gson.toJson(classSchedules.get(0).getPm2());
        }
    }

    /**
     * 通过班级id，获取 班级财务 数组
     * @param id
     * @return
     */
    @Override
    public List<ClassExpenditure> findClassFinancial(Long id) {

        ClassExpenditureExample classExpenditureExample = new ClassExpenditureExample();
        classExpenditureExample.createCriteria().andClassIdEqualTo(id);
        classExpenditureExample.setOrderByClause("updated desc");
        return classExpenditureMapper.selectByExample(classExpenditureExample);
    }

    /**
     * 获取班级考勤表，
     * @param id
     * @return
     */
    @Override
    public List<ClassCheckingIn> findClassCheckingInByClassId(Long id) {

        ClassCheckingInExample classCheckingInExample = new ClassCheckingInExample();
        classCheckingInExample.createCriteria().andClassIdEqualTo(id);
        classCheckingInExample.setOrderByClause("student_id asc");
        return classCheckingInMapper.selectByExample(classCheckingInExample);
    }

    /**
     *  获取班级最近三次的消费记录，转为json格式，返回到控制器。
     * @param id
     * @return
     */
    @Override
    public String getLastThreeTimesExpenditureJson(Long id) {

        // 获取班级消费记录列表
        ClassExpenditureExample classExpenditureExample = new ClassExpenditureExample();
        classExpenditureExample.createCriteria().andClassIdEqualTo(id);
        classExpenditureExample.setOrderByClause("updated desc");
        List<ClassExpenditure> classExpenditures = classExpenditureMapper.selectByExample(classExpenditureExample);

        List<String> labels = new ArrayList<>();
        List<Long> datas = new ArrayList<>();

        int i = 0;
        for (ClassExpenditure c : classExpenditures) {

            if (i++ >= 3) break;
            labels.add(FormatConversion.DateToString(c.getUpdated()));
            datas.add(c.getAmount());
        }

        List<Object> data = new ArrayList<>();
        data.add(labels);
        data.add(datas);

        return Json.toJson(data);
    }
}
