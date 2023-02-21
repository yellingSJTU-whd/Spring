package com.example.dao.impl;

import com.example.dao.AccountDao;
import com.example.pojo.Account;
import com.example.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account selectByActno(String actno) {
        var session = SqlSessionUtil.establishSession();
        Account act = session.selectOne("account.selectByActno", actno);
        session.close();
        return act;
    }

    @Override
    public int updateByActno(Account act) {
        var session = SqlSessionUtil.establishSession();
        var affectedRow = session.update("account.updateByActno", act);
        session.commit();
        session.close();
        return affectedRow;
    }
}
