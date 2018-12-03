package jpa.Exceptions;

public class MyBatchException extends RuntimeException {
    public MyBatchException(String message) {
        super(message);
    }
}
