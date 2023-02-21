package com.example.dao;

import com.example.pojo.Account;

public interface AccountDao {
    Account selectByActno(String actno);

    int updateByActno(Account act);
}
