package com.example.service.impl;

import com.example.dao.AccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.exception.InsufficientMoneyException;
import com.example.exception.UnknownException;
import com.example.pojo.Account;
import com.example.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao dao;
    @Override
    public void transfer(String fromActno, String toActno, double amount) throws InsufficientMoneyException, UnknownException {
        checkAccountDao();
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
    }

    private void checkAccountDao() {
        if (dao == null) {
            dao = new AccountDaoImpl();
        }
    }
}
