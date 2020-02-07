import com.wkk.dao.UserDao;
import com.wkk.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Time: 20-2-7上午10:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MyTest {
    @Test
    public void test() throws IOException {
//        // 对应的resource
//        String resource = "mybatis/mybatis-config.xml";
//        // 流读取
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        List<User> users = mapper.selectUser();
//        for (User user : users) {
//            System.out.println(user);
//
//        }
        // 以上为使用纯Mybatis配置

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserDao userDaoImpl = context.getBean("userDaoImpl", UserDao.class);
        List<User> users = userDaoImpl.selectUser();
        for (User user : users) {
            System.out.println(user);

        }


    }

}
