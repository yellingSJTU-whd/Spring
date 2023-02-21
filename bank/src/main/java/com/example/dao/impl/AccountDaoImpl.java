package com.example.dao.impl;

import com.example.dao.AccountDao;
import com.example.pojo.Account;
import com.example.utils.SqlSessionUtil;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account selectByActno(String actno) {
        var session = SqlSessionUtil.fetchSession();
        return session.selectOne("account.selectByActno", actno);
    }

    @Override
    public int updateByActno(Account act) {
        var session = SqlSessionUtil.fetchSession();
        return session.update("account.updateByActno", act);
    }
}
