package com.zs.hiki.settings.web.controller;

import com.zs.hiki.settings.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/myweb/")
public class WebController {
    @RequestMapping(value = "check_loginTimeOut.do",produces = "application/json;charset=utf8")
    @ResponseBody
    public Object checkLoginTimeOut(HttpServletResponse resp, HttpServletRequest req){
        Member user = (Member)req.getSession().getAttribute("user");
        String json = "{\"needReLogin\":";//字符串拼接建议使用StringBuilder,减小内存压力,这里偷点懒
        if (user!=null){
            json += "false";
        }else{
            json += "true";
        }
        json += "}";
        return json;
    }
}
