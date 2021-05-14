package com.zs.hiki.settings.web.HandlerInterceptors;

import com.zs.hiki.settings.domain.Member;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyWebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user")!=null){
            return true;
        }else return request.getRequestURI().contains("login") || request.getRequestURI().contains("reg");
    }
}
