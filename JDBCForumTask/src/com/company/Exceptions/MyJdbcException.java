package com.company.Exceptions;

public class MyJdbcException extends RuntimeException {
    public MyJdbcException(String message) {
        super(message);
    }

    public MyJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}
