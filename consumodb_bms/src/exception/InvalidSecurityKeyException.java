package exception;

public class InvalidSecurityKeyException extends RuntimeException {
    public InvalidSecurityKeyException(String message) {
        super(message);
    }
}
