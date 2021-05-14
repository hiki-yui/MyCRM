import com.mysql.cj.xdevapi.JsonString;
import com.zs.hiki.settings.dao.MemberDao;
import com.zs.hiki.settings.dao.T_UsersDao;
import com.zs.hiki.settings.domain.Member;
import com.zs.hiki.settings.domain.Users;
import com.zs.hiki.utils.JsonUtils;
import com.zs.hiki.utils.MyBatisUtil;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.*;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MyTest {
    @Test
    public void test1() {
        System.out.println(new Date());
        String resource = "ApplicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
        T_UsersDao dao =(T_UsersDao) ac.getBean("t_UsersDao");
        Method[] methods = dao.getClass().getMethods();
        for (Method m:methods) {
            System.out.println(m.getName());
        }
        Class[] classes=dao.getClass().getInterfaces();
        for (Class c:classes) {
            System.out.println(c.getName());
        }
        System.out.println(JsonUtils.getJson(dao.selectAll()));
    }
    @Test
    public void getUid() {
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }

    @Test
    public void test2(){
        Users m=new Users();
        m.setMember(new Member());
        System.out.println(MyBatisUtil.beMap(m));
    }

}
