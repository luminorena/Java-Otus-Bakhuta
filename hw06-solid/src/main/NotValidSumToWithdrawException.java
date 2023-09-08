package main;

/**
 * @exception NotValidSumToWithdrawException вызывается, если нельзя выдать сумму полностью
 * по причине отсутствия заданных номиналов.
 */
public class NotValidSumToWithdrawException extends RuntimeException{
    public NotValidSumToWithdrawException(String message) {
        super(message);
    }
}
