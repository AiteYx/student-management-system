package com.hbsfdx.system.controller.interceptor;

import com.hbsfdx.system.pojo.Student;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 班级权限拦截器
 * 权限不够的人不可以使用班委的功能
 */
public class ClassPermissionsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Student user = (Student) request.getSession().getAttribute("user");
        if (user.getClassLeader() == null || user.getClassLeader().equals(""))  {

            response.sendRedirect(request.getContextPath() + "/permissionDenied.do?mesg=仅班委有权限使用此功能！");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
