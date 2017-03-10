package com.leonkim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class LocalConnectionMaker implements ConnectionMaker {
    public Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_local_db", "root", "");
        return con;
    }
}
