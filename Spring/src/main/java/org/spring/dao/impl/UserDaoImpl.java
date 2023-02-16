package org.spring.dao.impl;

import org.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("inserting user");
    }
}
