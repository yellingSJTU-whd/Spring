package com.example.service.impl;

import com.example.dao.impl.AccountDaoImpl;
import com.example.exception.InsufficientMoneyException;
import com.example.exception.UnknownException;
import com.example.service.AccountService;
import com.example.utils.SqlSessionUtil;

public class AccountServiceImpl implements AccountService {

    @Override
    public void transfer(String fromActno, String toActno, double amount) throws InsufficientMoneyException, UnknownException {
        var session = SqlSessionUtil.fetchSession();
        var dao = new AccountDaoImpl();
        var fromAct = dao.selectByActno(fromActno);
        var fromBalance = fromAct.getBalance();

        if (fromBalance < amount) {
            throw new InsufficientMoneyException("余额不足");
        }

        var toAct = dao.selectByActno(toActno);
        fromAct.setBalance(fromBalance - amount);
        toAct.setBalance(toAct.getBalance() + amount);

        if (dao.updateByActno(fromAct) + dao.updateByActno(toAct) != 2) {
            throw new UnknownException("转账失败，原因未知");
        }

        session.commit();
        SqlSessionUtil.closeSession(session);
    }
}
