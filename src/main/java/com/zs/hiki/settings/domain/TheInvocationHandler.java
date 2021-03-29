package com.zs.hiki.settings.domain;

import com.zs.hiki.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TheInvocationHandler implements InvocationHandler {
    private Object o;

    public TheInvocationHandler(Object o) {
        this.o = o;
    }

    public Object invoke(Object proxy, Method method,Object[] args){
        SqlSession session=MyBatisUtil.getSession();
        Object result=null;
        try{
            result=method.invoke(o,args);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }finally{
            MyBatisUtil.close();
        }
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),this);
    }
}
