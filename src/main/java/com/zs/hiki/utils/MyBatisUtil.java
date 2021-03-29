package com.zs.hiki.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static String resource="mybatis-config.xml";
    private static SqlSessionFactory factory;
    static{
        try {
            InputStream in=Resources.getResourceAsStream(resource);
            factory= new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    public static SqlSession getSession(){
        SqlSession session=(SqlSession) threadLocal.get();
        if (session==null){
            session=factory.openSession();
            threadLocal.set(session);
            return session;
        }
        return session;
    }
    public static void close(){
        threadLocal.get().close();
        threadLocal.remove();
    }
}
