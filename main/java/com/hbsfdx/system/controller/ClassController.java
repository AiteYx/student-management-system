package com.hbsfdx.system.controller;

import com.hbsfdx.system.pojo.*;
import com.hbsfdx.system.service.ClassService;
import com.hbsfdx.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ClassController {

    @Autowired
    ClassService classService;
    @Autowired
    StudentService studentService;

    /**
     * 班级财务记录
     * @param request
     * @return
     */
    @RequestMapping("/classFinancial.do")
    public String classFinancial(HttpServletRequest request) {

        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        List<ClassExpenditure> classExpenditureList = classService.findClassFinancial(claz.getId());
        request.setAttribute("classExpenditureList", classExpenditureList);
        return "system/student/class_financial";
    }

    /**
     * 查询班级成员身份（政治面貌，班干）
     * @param request
     * @return
     */
    @RequestMapping("/classShow.do")
    public String classShow(HttpServletRequest request) {

        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        // 1 查找班级所有学生，需要政治面貌，班干
        List<Student> students = studentService.findStuByClassId(claz.getId());
        request.setAttribute("stuList", students);
        return "system/student/class_show";
    }

    /**
     * 到发布消息的页面
     * @return
     */
    @RequestMapping("/classMessage.do")
    public String classMessage() {
        return "system/student/leader_push_message";
    }

    /**
     * 推送消息到数据库
     * @param request
     * @return
     */
    @RequestMapping("/pushMessage.do")
    public void pushMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String local = request.getParameter("messageLocal");
        String time = request.getParameter("messageTime");
        String msgContext = request.getParameter("messageContext");
        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");

        boolean ok = classService.addMessage(local, time, msgContext, claz.getId());
        response.sendRedirect(request.getContextPath() + "/stuIndex.do");
    }

    /**
     * 班级财务页面的ajax
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/classFinancialAjax.do")
    public void classFinancialAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        String r = classService.classFinancialAjax(claz.getId());

        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(r);
    }

    /**
     * 班级考勤页面的ajax
     * 查找到课程名称之后响应给浏览器
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/leaderCheckingInAjax.do")
    public void leaderCheckingInAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int week_times = Integer.parseInt(request.getParameter("week_times"));
        String week = request.getParameter("week");
        String clazId = request.getParameter("clazId");
        String cur_times = request.getParameter("cur_times");

//        获得单双周 ， 再查询对应的课程，获取课程名称。
        String ClazName = classService.findClassScheduleJsonName((week_times / 2) == 0 ? "双周" : "单周", Long.parseLong(week), Long.parseLong(clazId), cur_times);

        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ClazName);
        return;
    }

    /**
     * 获取考勤记录，并且发送到页面上。
     * @param request
     * @return
     */
    @RequestMapping("/classViewCheckingIn.do")
    public String classViewCheckingIn(HttpServletRequest request) {

        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        List<ClassCheckingIn> classCheckingIns = classService.findClassCheckingInByClassId(claz.getId());
        request.setAttribute("classCheckingIns", classCheckingIns);

        return "system/student/class_checking_in";
    }

    @RequestMapping("/viewClassMessage.do")
    public String viewClassMessage(HttpServletRequest request) {

        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        List<ClassMessage> classMessage = classService.findClassMessage(claz.getId());
        request.setAttribute("classMessage", classMessage);
        return "system/student/class_message";
    }
}
