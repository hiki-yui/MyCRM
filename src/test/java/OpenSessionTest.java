import com.zs.hiki.settings.dao.T_UsersDao;
import com.zs.hiki.settings.domain.Users;
import com.zs.hiki.utils.MD5Util;
import com.zs.hiki.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OpenSessionTest {
    public static void main(String[] args) {
        SqlSession session=MyBatisUtil.getSession();
        T_UsersDao dao=session.getMapper(com.zs.hiki.settings.dao.T_UsersDao.class);
        List<Users> list=(List<Users>) dao.selectAll();
        System.out.println(list);
        MyBatisUtil.close();
        Date date=new Date();
        date.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date later=format.parse("2021-9-1 7:00:00");
            System.out.println(later.compareTo(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(MD5Util.getMD5("yukinoshita.1.03"));

    }
}
