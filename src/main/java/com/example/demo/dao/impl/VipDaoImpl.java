package com.example.demo.dao.impl;

import com.example.demo.dao.VipDao;
import org.springframework.stereotype.Repository;

@Repository("vipDao")
public class VipDaoImpl implements VipDao {
    @Override
    public void insert() {
        System.out.println("inserting vip");
    }
}
