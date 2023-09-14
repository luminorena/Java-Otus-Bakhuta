package main;

public enum BankNotes {
    FIVE(5, 3),
    TEN(10, 2),
    FIFTY(50, 100),
    ONE_HUNDRED(100, 200),
    FIVE_HUNDREDS(500, 10),
    ONE_THOUSAND(1000, 30);

    private final int value;
    private final int count;

    BankNotes(int value, int count) {
        this.value = value;
        this.count = count;
    }


    public int getValue() {
        return value;
    }

    public int genCount() {
        return count;
    }




}
