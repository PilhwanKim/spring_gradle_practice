import com.leonkim.*;

import java.sql.SQLException;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class UserDaoTest {
    public static void main(String[] args) throws SQLException {
        String env = "local";

        UserDaoFactory userDaoFactory = new UserDaoFactory();
        UserDao dao;
        if(env.equals("prd")) {
            dao = userDaoFactory.getPrdUserDao();
        } else {
            dao = userDaoFactory.getLocalUserDao();
        }

        User user = new User();
        user.setId("leon0517-1");
        user.setName("pilhwan kim");
        user.setPassword("12345");
        dao.add(user);

        User user2 = dao.get("leon0517-1");
        System.out.println("id:" + user2.getId());
        System.out.println("password:" + user2.getPassword());
        System.out.println("name:" + user2.getName());
    }
}
