package com.company.Exceptions;

public class MyJdbcException extends RuntimeException {
    public MyJdbcException(String message) {
        super(message);
    }
}
