package com.zs.hiki.settings.service;

import com.zs.hiki.settings.dao.T_UsersDao;
import com.zs.hiki.settings.domain.TheInvocationHandler;
import com.zs.hiki.utils.JsonUtils;
import com.zs.hiki.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

public class ActivitiesService extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        SqlSession session=MyBatisUtil.getSession();
        TheInvocationHandler handler=new TheInvocationHandler(session.getMapper(com.zs.hiki.settings.dao.T_UsersDao.class));
        T_UsersDao dao=(T_UsersDao)handler.getProxy();
        List list=dao.selectAll();
        String json=JsonUtils.getJson(list);
        PrintWriter writer=response.getWriter();
        writer.write(json);
        session.close();
        System.out.println(json);
    }
}
