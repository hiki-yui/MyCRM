package com.zs.hiki.settings.web.controller;


import com.zs.hiki.settings.domain.Member;
import com.zs.hiki.settings.service.MService;
import com.zs.hiki.settings.service.MembersService;
import com.zs.hiki.utils.JsonUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myweb/")
public class Members {
    @Resource
    MService service;

    @RequestMapping(value="memberappend.do")
    public void append(HttpServletRequest request,HttpServletResponse resp, Member member){
        String mName = member.getmName();
        String regDate = member.getRegDate();
        if (!"".equals(mName)&&!"".equals(regDate)){
            if (mName!=null&&regDate!=null){
                Member user = (Member)request.getSession().getAttribute("user");
                member.setCreator(user.getId());
                service.appendMember(member);
            }
        }
    }


    @RequestMapping(value="memberselect.do",produces="application/json;charset=utf-8")
    @ResponseBody
    public String select(HttpServletResponse response,Member member,Integer page,Integer size){
        if (size==null){
            return null;
        }
        Map map=service.select(page,size,member);
        return JsonUtils.getJson(map);
    }

    @RequestMapping(value="login.do",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest req,HttpServletResponse resp, Member member){
        String json="{";//json字符串
        if (member!=null){//如果请求参数没值就不调用方法
            Member user=service.login(member);//调用service的login方法,返回一个完整的用户信息
            if (user!=null){//如果没有用户信息,表明密码或用户名输入错误
                req.getSession().setAttribute("user",user);//将完整用户信息放入会话作用域中作为令牌使用
                json+="\"success\":true}";//该拼接的json表明登录成功
            }else{
                json+="\"success\":false,\"message\":\"用户名或密码不正确\"}";
            }
        }else{
            json+="\"success\":false,\"message\":\"用户不存在\"}";
        }
        return json;
    }

    @RequestMapping(value = "reg.do",produces = "application/json;charset=utf8",method = RequestMethod.POST)
    @ResponseBody
    public Object reg(HttpServletRequest request,HttpServletResponse resp,Member member){
        String json="{";
        if(member!=null){//检验是否有请求参数
            Member result=service.reg(member);//注册用户信息
            if (result!=null){//检查是否注册成功,成功的话会有原先的注册信息
                login(request,resp,member);//成功的话将原先注册信息
                json+="\"success\":true}";
            }else{
                json+="\"success\":false,\"message\":\"系统繁忙请稍后再试\"}";
                //注册失败
            }
            return json;//通知前端页面
        }
        return null;//在没请求参数的情况下什么也不做
    }

    @RequestMapping(value = "regCheckLoginName.do",produces="application/json;charset=utf8")
    @ResponseBody
    public Object checkLoginName(Member member){
        Member result=service.selectLoginName(member);
        String json="{\"hadLoginName\":";
        if (result!=null){
            json+="true}";
        }else{
            json+="false}";
        }
        return json;
    }

    @RequestMapping(value = "regCheckMember.do",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object checkMemberName(Member member){
        Member  result = service.selectMemberName(member);
        String json="{\"hadUser\":";
        if (result!=null){
            json+="true";
            if (result.getLoginName()!=null){
                json+=",\"hadTaken\":true";
            }
        }else{
            json+="false";
        }
        json+="}";
        return  json;
    }

    @RequestMapping(value="memberdelete")
    public void deleteMember(@RequestParam(value = "id[]") String[] id){
        if (id!=null&&id.length!=0){
            service.deleteMember(id);
        }else{
            throw new NullPointerException("没有输入请求参数");
        }
    }
}


