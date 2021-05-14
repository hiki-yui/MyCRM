package com.zs.hiki.settings.service;

import com.zs.hiki.settings.dao.MemberDao;
import com.zs.hiki.settings.domain.Exception.NotHaveLoginNameException;
import com.zs.hiki.settings.domain.Exception.NotHaveLoginPassWordException;
import com.zs.hiki.settings.domain.Member;
import com.zs.hiki.utils.MD5Util;
import com.zs.hiki.utils.MyBatisUtil;
import com.zs.hiki.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class MembersService implements MService{

    private MemberDao dao;

    private ThreadLocal<Member> tl = new ThreadLocal<>();

    public MemberDao getDao() {
        return dao;
    }

    public void setDao(MemberDao dao) {
        this.dao = dao;
    }

    public void appendMember(Member member){
        if (member!=null){
            member.setId(UUID.randomUUID().toString().replaceAll("-",""));
            dao.append(member);
        }else{
            throw new NullPointerException("没有成员对象");
        }
    }

    @Override
    public void editMember(Member member) {
        if (member!=null){
            dao.upDate(member);
        }
    }

    public Map<String,Object> select(Integer page, Integer size, Member member) {
        //返回值用的map
        Map<String,Object> returnMap=new HashMap<>();
        List<Member> list = dao.select(member);//获取过滤出的数据
        returnMap.put("count",list.size());//添加数据量
        List list2 = PageUtils.cutBase(list,page,size);//分页,筛选出只要展示的数据
        returnMap.put("base",list2);//将数据放入map中
        return returnMap;
    }

    @Override
    public Member login(Member member) {
        if (member.getLoginPassWord()!=null){
            member.setLoginPassWord(MD5Util.getMD5(member.getLoginPassWord()));//加密
        }else{
            throw new NotHaveLoginPassWordException("登录信息中没有密码");
        }
        if(member.getLoginName()!=null){
            member.setLoginName(MD5Util.getMD5(member.getLoginName()));//加密
        }else{
            throw new NotHaveLoginNameException("登录信息中没有账号");
        }
        return dao.login(member);//查询是否有该用户
    }

    @Override
    public Member reg(Member member) {//(注册的前提要求是数据库中有相关的成员信息,但该成员信息中没有密码和账号)
        if(member.getLoginName()!=null) {
            member.setLoginName(MD5Util.getMD5(member.getLoginName()));
        }else{
            throw new NotHaveLoginNameException("没有输入账号信息");
        }
        if (member.getLoginPassWord()!=null) {
            member.setLoginPassWord(MD5Util.getMD5(member.getLoginPassWord()));//加密信息
        }else{
            throw new NotHaveLoginPassWordException("没有密码信息");
        }
        //需要成员手动注册
        if (dao.reg(member)==1){//如果有数据发送了变化,说明注册成功
            return member;//原来的注册信息返回(可以当登录账号密码使用)
        }
        return null;//没有数据变化代表注册失败,不给予原先的注册信息
    }

    @Override
    public Member selectLoginName(Member member) {
        return selectMember(member);
    }

    @Override
    public Member selectMemberName(Member member) {
        return selectMember(member);
    }

    private Member selectMember(Member member) {
        //将原数据替换为加密后的数据
        if(member.getLoginPassWord()!=null) {
            member.setLoginPassWord(MD5Util.getMD5(member.getLoginPassWord()));
        }
        if (member.getLoginName()!=null){
            member.setLoginName(MD5Util.getMD5(member.getLoginName()));
        }
        //查询
        List<Member> members = dao.selectNotInLike(member);
        if (members.size()!=0){
            return members.get(0);
        }else{
            return null;
        }
    }

    @Override
    public void deleteMember(String[] id) {
       dao.deleteMember(id);
    }
}
