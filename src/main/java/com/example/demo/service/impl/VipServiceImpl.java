package com.example.demo.service.impl;

import com.example.demo.dao.VipDao;
import com.example.demo.service.VipService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("vipService")
public class VipServiceImpl implements VipService {
    @Resource(name = "vipDao")
    private VipDao vipDao;
    @Override
    public void insertVip() {
        vipDao.insert();
    }
}
