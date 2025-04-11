package com.integracion.exception;

public class DataValidationException  extends RuntimeException {
    private String message;

    public DataValidationException() {}

    public DataValidationException(String msg) {
        super(msg);
        this.message = msg;
    }
}