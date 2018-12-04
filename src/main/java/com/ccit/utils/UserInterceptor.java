package com.ccit.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
HandlerInterceptor主要的作用是拦截用户的请求并进行相应的处理.eg:进行权限验证,或者判断用户是否登陆
 */
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 该方法将在请求处理之前进行调用,可以在这个方法中进行一些前置初始化操作或者是对当前请求的一个预处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    /**
     * 只有在当前interceptor中的preHandle方法返回值为true时才能调用.当前请求处理之后,controller方法调用之后执行
     * 会在dispatcherServlet进行视图返回渲染之前被调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法在dispatcherServlet渲染了对应的视图之后执行.这个方法的主要作用是用于进行资源清理工作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
