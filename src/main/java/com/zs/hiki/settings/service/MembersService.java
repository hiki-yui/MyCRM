package com.zs.hiki.settings.service;

import com.zs.hiki.settings.dao.MemberDao;
import com.zs.hiki.settings.domain.Member;
import com.zs.hiki.utils.MyBatisUtil;
import com.zs.hiki.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class MembersService implements MService{

    private MemberDao dao;

    private ThreadLocal<Member> tl = new ThreadLocal();

    public MemberDao getDao() {
        return dao;
    }

    public void setDao(MemberDao dao) {
        this.dao = dao;
    }

    @Deprecated
    public void setMember(HttpServletRequest req){
        Enumeration<String> parameterNames=req.getParameterNames();
        Member member = new Member();
        Map<String,String> map = new HashMap<String,String>();
        while(parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            String value=req.getParameter(name);
            map.put(name,value);
        }
        member.setMName(map.get("mname"));
        member.setClassroom(map.get("classroom"));
        member.setCreator(map.get("creator"));
        member.setGender(map.get("gender"));
        member.setHead(map.get("head"));
        member.setRegDate(map.get("regDate"));
        member.setMWork("work");
        member.setEditor("editor");
        tl.set(member);
    }

    public void appendMember(){
        Member member = tl.get();
       appendMember(member);
    }

    public void appendMember(Member member){
        if (member!=null){
            member.setId(UUID.randomUUID().toString().replaceAll("-",""));
            dao.append(member);
        }else{
            throw new NullPointerException("没有设置成员对象");
        }
    }
    public void editMember(){
        Member member=tl.get();
        if (member!=null){
            dao.upDate(member);
        }

    }

    public Map<String,Object> select(Integer page,Integer size,Member member) {
        //返回值用的map
        Map<String,Object> returnMap=new HashMap<>();
        List<Member> list = dao.select(member);
        returnMap.put("count",list.size());
        List list2 = PageUtils.cutBase(list,page,size);
        returnMap.put("base",list2);
        return returnMap;
    }
}
