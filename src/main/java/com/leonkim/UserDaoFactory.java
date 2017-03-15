package com.leonkim;

import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */

@Configuration
public class UserDaoFactory {

    @Bean
    public DataSource getLocalDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_local_db");
        dataSource.setUsername("root");

        return dataSource;
    }

    @Bean
    public DataSource getPrdDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_prd_db");
        dataSource.setUsername("root");

        return dataSource;
    }
    @Bean
    public UserDao localUserDao() {
        DataSource dataSource = getLocalDataSource();

        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource);
        return userDao;
    }

    @Bean
    public UserDao prdUserDao() {
        DataSource dataSource = getPrdDataSource();

        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource);
        return userDao;
    }
}
