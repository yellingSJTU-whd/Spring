package com.example.exception;

public class InsufficientMoneyException extends Exception {
    public InsufficientMoneyException() {

    }

    public InsufficientMoneyException(String msg) {
        super(msg);
    }

    public InsufficientMoneyException(Throwable cause){
        super(cause);
    }
}
