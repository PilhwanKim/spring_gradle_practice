import com.leonkim.*;

import java.sql.SQLException;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class UserDaoTest {
    public static void main(String[] args) throws SQLException {
        String env = "local";

        ConnectionMaker connectionMaker;
        if(env.equals("prd")) {
            connectionMaker = new PrdConnectionMaker();
        } else {
            connectionMaker = new LocalConnectionMaker();
        }
        UserDao dao = new UserDao(connectionMaker);

        User user = new User();
        user.setId("leon0517");
        user.setName("pilhwan kim");
        user.setPassword("12345");
        dao.add(user);

        User user2 = dao.get("leon0517");
        System.out.println("id:" + user2.getId());
        System.out.println("password:" + user2.getPassword());
        System.out.println("name:" + user2.getName());
    }
}
