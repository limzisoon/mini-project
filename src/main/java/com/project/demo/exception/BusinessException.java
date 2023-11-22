package com.project.demo.exception;

public class BusinessException extends Exception {

    static final long serialVersionUID = 0L;

    public BusinessException(String debugMessage) {
        super(debugMessage);
    }

    public BusinessException(String debugMessage, Throwable t) {
        super(debugMessage, t);
    }
}