import com.wkk.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Time: 20-2-6下午4:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("名字: " + student.getName());
        System.out.println("地址: " + student.getAddress());
        System.out.println("书籍: " + student.getBooks());
        System.out.println("爱好： " + student.getHobbys());
        System.out.println("学生卡: " + student.getCard());
        System.out.println("游戏: " + student.getGames());
        System.out.println("游戏: " + student.getGames());
        System.out.println("是否已婚: " + student.getWife());


    }
}
