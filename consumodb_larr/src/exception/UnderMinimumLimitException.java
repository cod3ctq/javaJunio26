package exception;

public class UnderMinimumLimitException extends RuntimeException {
    public UnderMinimumLimitException(String message) {
        super(message);
    }
}
