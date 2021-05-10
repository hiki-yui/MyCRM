package com.zs.hiki.settings.web.controller;

import com.zs.hiki.settings.domain.Member;
import com.zs.hiki.settings.service.MembersService;
import com.zs.hiki.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myweb/")
public class Members {
    @Resource
    MembersService service;

    @RequestMapping(value="memberappend.do")
    public void append(HttpServletRequest request, HttpServletResponse response, Member member){
        service.appendMember(member);
        System.out.println(member);
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
}
