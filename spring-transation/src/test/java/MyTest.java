import com.wkk.dao.UsersDao;
import com.wkk.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Time: 20-2-7下午4:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MyTest {
    @Test
    public void Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersDao userDaoImpl = context.getBean("userDaoImpl", UsersDao.class);
        for (Student user : userDaoImpl.queryUser()) {
            System.out.println(user.getId() +" " + user.getName() + " " + user.getPassword());

        }
    }
}
