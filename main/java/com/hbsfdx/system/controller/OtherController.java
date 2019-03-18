package com.hbsfdx.system.controller;

import com.hbsfdx.system.pojo.ClassAndGrade;
import com.hbsfdx.system.pojo.Student;
import com.hbsfdx.system.pojo.Teacher;
import com.hbsfdx.system.service.ClassService;
import com.hbsfdx.system.service.StudentService;
import com.hbsfdx.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OtherController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassService classService;

    /**
     * 登录
     * 自行查找对应的学生或者教师
     * 将user，claz（班级）发送到session域中
     *
     * 登录失败则返回login页面
     * @param request
     * @param response
     * @param userid
     * @param password
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/login.do")
    public void login(HttpServletRequest request, HttpServletResponse response, String userid, String password) throws IOException, ServletException {

        Student stu = null;
        Teacher tea = null;
        ClassAndGrade claz = null;

        if (!userid.matches("[0-9]+")) {

            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

//      查找是否存在该学生，并发送到学生页面
        stu = studentService.findStuByUidAndPwd(userid, password);
        if (stu != null) {

            claz = studentService.findClzById(stu.getClassId());
            request.getSession().setAttribute("user", stu);
            request.getSession().setAttribute("claz", claz);
            response.sendRedirect(request.getContextPath() + "/stuPersonalInformation.do");
            return;
        }

//        查找是否存在教师，并且发送到教师页面
        tea = teacherService.findTeaByUidAndPwd(userid, password);
        if (tea != null) {

            claz = teacherService.findClzById(tea.getClassId());
            request.getSession().setAttribute("user", tea);
            request.getSession().setAttribute("claz", claz);
            response.sendRedirect("");
            response.sendRedirect(request.getContextPath() + "/.do");
            return;
        }

//        教师学生均不存在，则发送到登录页面
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    /**
     * 退出登录
     * 将session域中相关信息设为null，同时发送到login页面
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/logout.do")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {


        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("claz", null);
        request.getRequestDispatcher(request.getContextPath() + "/login.jsp");
        return;
    }

    /**
     * 权限不足
     * 获取参数，将参数打印到页面上
     * @param request
     * @return
     */
    @RequestMapping("/permissionDenied.do")
    public String permissionDenied(HttpServletRequest request) {

        String mesg = request.getParameter("mesg");
        request.setAttribute("mesg", mesg);
        return "permission_denied";
    }

    /**
     * 修改密码
     * 获取用户输入信息，对比信息是否正确，在修改密码。
     * @param request
     */
    @RequestMapping("/forgetPassword.do")
    public void forgetPassword(HttpServletRequest request) {

        String userid = request.getParameter("userid");
        String idCard = request.getParameter("idCard");
        String bankCard = request.getParameter("bankCard");
        String password = request.getParameter("password");
        boolean ok = studentService.checkAndChangePassword(userid, idCard, bankCard, password);
        if (ok) request.getRequestDispatcher(request.getContextPath() + "/login.jsp");
        else request.getRequestDispatcher(request.getContextPath() + "/forget_password.jsp");
        return;
    }

    /**
     * 查找该学生的考勤表，分解出信息，发送给页面。
     * @param request
     * @param response
     */
    @RequestMapping("/stuCheckingInAjax.do")
    public void stuCheckingInAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Student student = (Student) request.getSession().getAttribute("user");
        String json = studentService.getStuCheckingInJson(student.getId());

        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /**
     * 查找班级最近三次的消费记录，没有三次的话，有多少次是多少次。
     * @param request
     * @param response
     */
    @RequestMapping("/classExpenditureAjax.do")
    public void classExpenditureAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        String json = classService.getLastThreeTimesExpenditureJson(claz.getId());

        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @RequestMapping("/lastExamScore.do")
    public void lastExamScore(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Student student = (Student) request.getSession().getAttribute("user");
        String json = studentService.getStuLastExamScoreJson(student.getId());

        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
