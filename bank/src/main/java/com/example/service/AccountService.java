package com.example.service;

import com.example.exception.InsufficientMoneyException;
import com.example.exception.UnknownException;

public interface AccountService {
    void transfer(String fromActno, String toActno, double money) throws InsufficientMoneyException, UnknownException;
}
