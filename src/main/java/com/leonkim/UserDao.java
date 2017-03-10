package com.leonkim;

import java.sql.*;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class UserDao {
    public void add(User user) throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_practice_db", "root", "");

        PreparedStatement ps = con.prepareStatement("insert into users(id, password, name) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getName());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public User get(String id) throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_practice_db", "root", "");

        PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
        ps.setString(1,  id);
        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));

        rs.close();
        ps.close();
        con.close();

        return user;
    }

    public static void main(String[] args) throws SQLException {
        UserDao dao = new UserDao();

//        User user = new User();
//        user.setId("leon0517-3");
//        user.setName("pilhwan kim");
//        user.setPassword("12345");
//        dao.add(user);

        User user = dao.get("leon0517-3");
//
        System.out.println("id:" + user.getId());
        System.out.println("password:" + user.getPassword());
        System.out.println("name:" + user.getName());
    }

}
