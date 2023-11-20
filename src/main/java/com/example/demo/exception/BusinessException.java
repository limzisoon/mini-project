package com.example.demo.exception;

public class BusinessException extends BaseCheckedException {

    static final long serialVersionUID = 0L;

    public BusinessException(String debugMessage) {
        super(debugMessage);
    }

    public BusinessException(String debugMessage, Throwable t) {
        super(debugMessage, t);
    }
}