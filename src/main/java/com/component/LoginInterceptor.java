package com.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author Hedon Wang
 * @create 2020-06-03 20:08
 */
public class LoginInterceptor implements HandlerInterceptor {

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入登录拦截器.....");

        String url = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();


        if (url.indexOf("anager")>=0){
            System.out.println("正在进行manager相关操作...");
            return true;
        }

        //判断 session 中是否有登录信息
        HttpSession session = request.getSession();
        String loginName = (String) session.getAttribute("loginName");
        if(loginName!=null){
            return true;
        }else{
            System.out.println("没有用户登录！");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
