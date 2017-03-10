package com.leonkim;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */

@Configuration
public class UserDaoFactory {
    @Bean
    public UserDao localUserDao() {
        ConnectionMaker connectionMaker = new LocalConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    @Bean
    public UserDao prdUserDao() {
        ConnectionMaker connectionMaker = new PrdConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
