package com.leonkim;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public interface ConnectionMaker {
    Connection getConnection() throws SQLException;
}
