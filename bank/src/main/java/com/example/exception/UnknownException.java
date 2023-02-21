package com.example.exception;

public class UnknownException extends Exception{
    public UnknownException(){}

    public UnknownException(String msg) {
        super(msg);
    }

    public UnknownException(Throwable cause) {
        super(cause);
    }
}
