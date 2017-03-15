package com.leonkim;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class UserDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection con = this.dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement("insert into users(id, password, name) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getName());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public User get(String id) throws SQLException {
        Connection con = this.dataSource.getConnection();

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

}
