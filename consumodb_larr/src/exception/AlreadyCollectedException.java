package exception;

public class AlreadyCollectedException extends RuntimeException {
    public AlreadyCollectedException(String message) {
        super(message);
    }
}
