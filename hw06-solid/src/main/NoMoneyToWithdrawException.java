package main;


public class NoMoneyToWithdrawException extends RuntimeException {
    public NoMoneyToWithdrawException(String message) {
        super(message);
    }
}
