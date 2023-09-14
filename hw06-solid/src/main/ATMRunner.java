package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ATMRunner implements ATM {
    private final int initialAtmSum;
    private int bankNotesR;

    public ATMRunner(int initialAtmSum) {
        this.initialAtmSum = initialAtmSum;

    }

    @Override
    public void withdrawMoney(int bankNotes) {
        try {

            bankNotesR = bankNotes;
            Integer result1 = 0;

            Optional<Integer> minValue = Arrays.stream(BankNotes.values())
                    .map(BankNotes::getValue).min(Integer::compareTo);

            long countValues = Arrays.stream(BankNotes.values())
                    .map(BankNotes::genCount).count();

            Supplier<Stream<Integer>> streamSupplier
                    = () -> Stream.of(BankNotes.values())
                    .map(BankNotes::getValue);
            List<Integer> withdrawList = new ArrayList<>();
            while (bankNotes >= minValue.get()) {
                int finalInitialValue = bankNotes;
                long finalCountValues = countValues;
                result1 = streamSupplier.get()
                        .filter(x -> x <= finalInitialValue && finalCountValues > 0).max(Integer::compareTo)
                        .stream().findFirst().orElse(null);
                bankNotes -= result1;
                countValues--;
                withdrawList.add(result1);
            }
            System.out.println("Сумма выдана минимальным количеством банкнот: " + withdrawList);
        } catch (NullPointerException e) {
            System.out.println("Сумму невозможно выдать полностью. Нет купюр.");
        }

    }

    @Override
    public void calculateRest() {
        int rest = initialAtmSum - bankNotesR;
        if (rest >= 0) {
            System.out.println("Остаток на счету: " + rest);
        } else throw new NoMoneyToWithdrawException("Запрошенная сумма больше первоначальной. Выдача невозможна.");


    }
}
