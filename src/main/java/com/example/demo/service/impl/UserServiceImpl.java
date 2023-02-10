package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;
    @Override
    public void insertUser() {
        userDao.insert();
    }
}
