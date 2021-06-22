package bank;

public class UnsupportedWithdrawalException extends RuntimeException {
    public UnsupportedWithdrawalException(String message) {
        super(message);
    }
}
