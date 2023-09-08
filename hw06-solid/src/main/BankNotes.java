package main;

public enum BankNotes {
    FIVE(5),
    TEN(10),
    FIFTY(50),
    ONE_HUNDRED(100),
    FIVE_HUNDREDS(500),
    ONE_THOUSAND(1000);

    private final int value;

    BankNotes(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }


}
