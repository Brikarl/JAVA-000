import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/18 17:34
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appCxt.xml");
        Student student = (Student) context.getBean("student01");
        student.hasClass();
    }
}
