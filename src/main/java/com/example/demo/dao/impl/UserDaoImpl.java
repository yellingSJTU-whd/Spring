package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("inserting user");
    }
}
