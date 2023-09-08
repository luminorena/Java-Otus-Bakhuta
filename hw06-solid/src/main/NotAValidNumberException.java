package main;

/**
 * @exception NotAValidNumberException вызывается, если пользователь ввёл некорректное число
 * суммы.
 */
public class NotAValidNumberException extends RuntimeException {
    public NotAValidNumberException(String message) {
        super(message);
    }
}
