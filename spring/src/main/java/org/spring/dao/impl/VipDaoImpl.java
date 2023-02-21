package org.spring.dao.impl;

import org.spring.dao.VipDao;
import org.springframework.stereotype.Repository;

@Repository("vipDao")
public class VipDaoImpl implements VipDao {
    @Override
    public void insert() {
        System.out.println("inserting vip");
    }
}
