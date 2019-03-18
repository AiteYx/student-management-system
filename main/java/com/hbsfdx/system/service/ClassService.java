package com.hbsfdx.system.service;

import com.hbsfdx.system.pojo.ClassCheckingIn;
import com.hbsfdx.system.pojo.ClassExpenditure;
import com.hbsfdx.system.pojo.ClassMessage;

import java.util.List;

public interface ClassService {

    String classFinancialAjax(Long id);

    List<ClassMessage> findClassMessage(Long id);

    Double findAveScoreByClassIdAndCourseId(Long courseId, Long classId, String term);

    boolean addMessage(String local, String time, String msgContext, Long id);

    String findClassScheduleJsonName(String s, long week, long clazId, String cur_times);

    List<ClassExpenditure> findClassFinancial(Long id);

    List<ClassCheckingIn> findClassCheckingInByClassId(Long id);

    String getLastThreeTimesExpenditureJson(Long id);
}
