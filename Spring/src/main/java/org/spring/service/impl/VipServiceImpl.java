package org.spring.service.impl;

import com.example.demo.dao.VipDao;
import org.spring.service.VipService;
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
