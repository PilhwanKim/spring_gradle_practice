import com.leonkim.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class UserDaoTest {
    public static void main(String[] args) throws SQLException {

        // ApplicationContext 선언
        ApplicationContext context;

        // AnnotationConfigApplicationContext 생성
        context = new AnnotationConfigApplicationContext(UserDaoFactory.class);

        String env = "local";
        UserDao dao;
        if(env.equals("prd")) {
            dao = context.getBean("prdUserDao", UserDao.class);
        } else {
            dao = context.getBean("localUserDao", UserDao.class);
        }

        User user = new User();
        user.setId("leon0517-6");
        user.setName("pilhwan kim");
        user.setPassword("12345");
        dao.add(user);

        User user2 = dao.get("leon0517-6");
        System.out.println("id:" + user2.getId());
        System.out.println("password:" + user2.getPassword());
        System.out.println("name:" + user2.getName());
    }
}
