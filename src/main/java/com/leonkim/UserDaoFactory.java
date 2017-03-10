package com.leonkim;

/**
 * Created by pilhwankim on 2017. 3. 10..
 */
public class UserDaoFactory {
    public UserDao getLocalUserDao() {
        ConnectionMaker connectionMaker = new LocalConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    public UserDao getPrdUserDao() {
        ConnectionMaker connectionMaker = new PrdConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
