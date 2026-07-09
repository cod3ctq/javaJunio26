package exception;

public class InsuffeicentBalanceException extends RuntimeException {
    public InsuffeicentBalanceException(String message) {
        super(message);
    }
}
