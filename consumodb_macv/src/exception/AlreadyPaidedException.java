package exception;

public class AlreadyPaidedException extends RuntimeException {
    public AlreadyPaidedException(String message) {
        super(message);
    }
}
