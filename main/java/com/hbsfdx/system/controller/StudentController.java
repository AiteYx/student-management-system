package com.hbsfdx.system.controller;

import com.google.gson.Gson;
import com.hbsfdx.system.pojo.ClassAndGrade;
import com.hbsfdx.system.pojo.*;
import com.hbsfdx.system.service.ClassService;
import com.hbsfdx.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    /**
     * 成绩查询,通过学期和id
     * @param request
     */
    @RequestMapping("/stuQueryScore.do")
    public String stuQueryScore(HttpServletRequest request) throws ServletException, IOException {

        String term = request.getParameter("term");
        if (term == null) {

            request.setAttribute("scores", null);
        } else {

            Student user = (Student) request.getSession().getAttribute("user");
            List<Score> scores = studentService.findScoreByIdAndTerm(term, user.getId());
            request.setAttribute("scores", scores);
        }
        if (term == null)   request.setAttribute("term", "选择学期");
        else request.setAttribute("term", term);
        return "system/student/student_score";
    }

    /**
     * 课程表查询
     * @param request
     * @param response
     */
    @RequestMapping("/stuSchoolTimetable.do")
    public String schoolTimetable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        Long clazId = claz.getId();
        List<ClassSchedule> classScheduleList = studentService.findClassScheduleByClassId(clazId);
        request.setAttribute("schedules", classScheduleList);
        return "system/student/student_timetable";
    }

    /**
     * 个人信息查询
     * 转发到jsp页面
     * @param request
     * @return
     */
    @RequestMapping("/stuPersonalInformation.do")
    public String personalInformation(HttpServletRequest request) {


        String mesg = request.getParameter("mesg");
        request.setAttribute("mesg", mesg);

        return "system/student/student_information";
    }

    /**
     * 更新学生的信息
     * @param request
     * @return
     */
    @RequestMapping("/stuUpdateInfor.do")
    public String updateStudentInfor(HttpServletRequest request) {

        String user_email = request.getParameter("user_email");
        String user_telephone = request.getParameter("user_telephone");
        Student user = (Student) request.getSession().getAttribute("user");
        boolean b = studentService.updateStudentEmailOrTelephone(user, user_email, user_telephone);
        return "system/student/student_information";
    }

    /**
     * 学生首页
     * 转发到个人信息页面
     * @param request
     * @return
     */
    @RequestMapping("/stuIndex.do")
    public String stuIndex(HttpServletRequest request) {


        return "system/student/student_information";
    }

    /**
     * 获取平均成绩
     */
    @RequestMapping("/aveScoreAjax.do")
    public  void aveScore(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        获取该学生的成绩
        Student user = (Student) request.getSession().getAttribute("user");
        String term = (String) request.getParameter("term");
        List<Score> scores = studentService.findScoreByIdAndTerm(term, user.getId());

//        通过该学生的每门课的成绩id，再加上班级id，学期，查出该班级该科目的平均成绩
        List<Double> classAve = new ArrayList<>();
        List<Long> stuScore = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        Long classId = user.getClassId();
        for (Score score : scores) {

            Double ave = classService.findAveScoreByClassIdAndCourseId(score.getCourseid(), classId, term);
            classAve.add(ave);
            stuScore.add(score.getScore());
            labels.add(score.getCourse());
        }

        Gson gson = new Gson();
        List<Object> ll = new ArrayList<>();
        ll.add(classAve);
        ll.add(stuScore);
        ll.add(labels);
        String r = gson.toJson(ll);

        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(r);
    }

    /**
     * 获取班级学生列表，并且转发到考勤页面
     * @param request
     * @return
     */
    @RequestMapping("/stuAttendance.do")
    public String stuAttendance(HttpServletRequest request){

        Student stu = (Student) request.getSession().getAttribute("user");
        ClassAndGrade claz = (ClassAndGrade) request.getSession().getAttribute("claz");
        List<Student> stuList = studentService.findStuByClassId(claz.getId());
        request.setAttribute("stuList",stuList);
        return "system/student/leader_checking_in";

    }

    /**
     * 根据提交的表单，更新班级考勤表格
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/submitClassAttendance.do")
    public void submitClassAttendance(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long week_times = null;
        String week = null;
        String cur_times = null;
        String[] split;
        String term = null;
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){

            String name = names.nextElement();
            String[] values = request.getParameterValues(name);

            switch (name) {
                case "week_times":
                    week_times = Long.valueOf(values[0]);
                    break;
                case "week":
                    week = values[0];
                    break;
                case "cur_times":
                    cur_times = values[0];
                    break;
                case "term":
                    term = values[0];
                    break;
                default:
                    for (String v : values) {

                        split = v.split("-");
                        if (split.length < 3)   continue;
                        studentService.submitClassCheckingIn(term, week_times, week, cur_times, split);
                    }
            }
        }

        response.sendRedirect( request.getContextPath() + "/stuIndex.do");
        return;
    }

    /**
     * 更新学生头像
     * @param user_image
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/changeStuImage.do")
    public void changeStuImage(MultipartFile user_image, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (user_image == null ||  user_image.isEmpty())   {

            response.getWriter().write("0");
            return ;
        }

        String path = request.getSession().getServletContext().getRealPath("img/userHeadPortrait");
        Student stu = (Student) request.getSession().getAttribute("user");
        studentService.changeHeadPortrait(path, stu.getId(), user_image);
        response.getWriter().write("1");
        return;

    }

    /**
     * 奖学金申请页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/stuActivityApply.do")
    public String stuActivityApply(HttpServletRequest request, HttpServletResponse response) {

        // 获得本人的申请记录，填入历史记录，分别获取各个奖金的申请人数
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("user");
        List<Apply> applies = studentService.findApplyByStuId(student.getId());
        long[] nums = studentService.findBursarysNum();

        session.setAttribute("applies" , applies);
        session.setAttribute("nums", nums);

        return "system/student/stuActivity_apply";
    }


    /**
     * 转发到详细页面
     * @return
     */
    @RequestMapping("/stuActivityApplyDetail.do")
    public String stuActivityApplyDetail() {

        return "system/student/stuActivity_apply_detail";
    }

    /**
     * 保存学生提交的奖金申请表到指定位置
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/submitApplyFile.do")
    public String submitApplyFile(MultipartFile file, HttpServletRequest request) {

        if (file == null || file.isEmpty()) {

            request.setAttribute("mesg", "请选择正确文件！");
            return "system/student/stuActivity_apply_detail";
        }

        String path = request.getSession().getServletContext().getRealPath("file/apply/studentFile");
        Student student = (Student) request.getSession().getAttribute("user");
        // 保存学生上传的文件
        // 保存该次申请   项目名 学生id 班级id 保存的文件的地址 审核情况 当前日期
        studentService.submitApplyFile(path, file, student.getId(), student.getClassId(), new Date());

        return "system/student/stuActivity_apply_detail";
    }

    /**
     * 修改密码
     * 判断旧密码是否正确，新密码是否一致
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/stuChangePassword.do")
    public String stuChangePassword(HttpServletRequest request) {

        String confirmPassword = request.getParameter("confirmPassword");
        String newPassword = request.getParameter("newPassword");

        if (confirmPassword == null && newPassword == null)
            return "system/student/stuActivity_password";

        if (confirmPassword == null || newPassword == null) {

            request.setAttribute("msg","新密码不可为空！");
            return "system/student/stuActivity_password";
        }

        if(newPassword.equals(confirmPassword)){
            String oldPassword = request.getParameter("oldPassword");
            Student stu = (Student) request.getSession().getAttribute("user");

            if (oldPassword.equals(stu.getPassword())){

                int i = studentService.changeStuPassword(stu,newPassword);
                request.getSession().setAttribute("user",stu);
                request.setAttribute("msg","密码修改成功!");
                return "system/student/stuActivity_password";

            }else{
                request.setAttribute("msg","旧密码输入有误,请检查后重新输入!");
                return "system/student/stuActivity_password";
            }
        }
        request.setAttribute("msg","两次密码输入不一致,请重新输入!");
        return "system/student/stuActivity_password";
    }

    /**
     * 查询同班同学，转发到评估页面
     * @param request
     * @return
     */
    @RequestMapping("/stuEvaluation.do")
    public String stuEvaluation(HttpServletRequest request){
        Student user = (Student) request.getSession().getAttribute("user");

        List<Student> list = studentService.findStuByClassId(user.getClassId());

        list.removeIf(student ->
                student.getId().equals(user.getId())
        );

        request.setAttribute("list",list);
        return "system/student/stuActivity_evaluation";
    }


    /***
     * 评估提交
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/stuSubmitEvaluation.do")
    public void stuSubmitEvaluation(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String[] users = request.getParameterValues("user");
        String[] a1 = request.getParameterValues("A1");
        String[] a2 = request.getParameterValues("A2");
        String[] a3 = request.getParameterValues("A3");
        String[] a4 = request.getParameterValues("A4");
        String[] a5 = request.getParameterValues("A5");
        String[] a6 = request.getParameterValues("A6");
        List<Long> score = new ArrayList<Long>();
        for (int i = 0;i < users.length; i ++){
            System.out.println(users[i]+" "+a1[i]+" "+a2[i]+" "+a3[i]+" "+a4[i]+" "+a5[i]+" "+a6[i]);
            Long stuId = Long.parseLong(users[i].split("-")[0]);
            Long classId = Long.parseLong(users[i].split("-")[1]);
            score.add(Long.parseLong(a1[i]));
            score.add(Long.parseLong(a2[i]));
            score.add(Long.parseLong(a3[i]));
            score.add(Long.parseLong(a4[i]));
            score.add(Long.parseLong(a5[i]));
            score.add(Long.parseLong(a6[i]));
            studentService.stuAddEvaluation(stuId,classId,score, (long) (users.length+1));
            score.clear();
        }
        response.sendRedirect(request.getContextPath() + "/stuIndex.do");

//        return "system/student/stuActivity_evaluation";
    }
}
