package main;

/**
 * @exception NotValidSumToWithdrawException вызывается, если невозможно выдать сумму, так как
 * она больше той, что есть изначально.
 */

public class NoMoneyToWithdrawException extends RuntimeException {
    public NoMoneyToWithdrawException(String message) {
        super(message);
    }
}
