package hibernate.Exceptions;

public class MyBatchException extends RuntimeException {
    public MyBatchException(String message) {
        super(message);
    }

    public MyBatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
