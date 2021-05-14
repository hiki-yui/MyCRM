package com.zs.hiki.settings.web.Filter;

import com.zs.hiki.settings.domain.Member;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        servletResponse.setContentType("text/html;charset=utf-8");
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (checkUser(req)||uri.contains("login")||uri.contains("reg")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            resp.sendRedirect(req.getContextPath() + "/login.html");
            filterChain.doFilter(req,resp);
        }
    }

    private Boolean checkUser(HttpServletRequest req){
        HttpSession session = req.getSession();
        Member member = (Member)session.getAttribute("user");
        return !(member==null);
    }
}