package main;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ATMRunner implements ATM {
    Random random = new Random();
    private int initialAtmSum;
    private int bankNotes;

    @Override
    public void getInitialAtmMoney() {
        initialAtmSum = Math.abs(10 + (int) (random.nextGaussian() * 1000) * 10);
        System.out.println(initialAtmSum);

    }

    @Override
    public int insertMoney() throws IOException {
        System.out.println("Доступные номиналы: \n" + Arrays.toString(BankNotes.values()) + "\n");
        System.out.println("Введите сумму, которую хотите получить: \n");

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String inputBanknotes = bufferedReader.readLine();

        if (new Scanner(inputBanknotes).hasNextInt()) {
            bankNotes = Integer.parseInt(inputBanknotes);
        } else {
            throw new NotAValidNumberException("Вводимый параметр должен быть положительным целым числом");
        }

        if (bankNotes <= 0) {
            throw new NotAValidNumberException("Вводимый параметр должен быть положительным целым числом");
        }

        int rest = initialAtmSum - bankNotes;

        if (rest >= 0) {
            System.out.println("Сумма для выдачи: " + bankNotes);
        } else throw new NoMoneyToWithdrawException("Запрошенная сумма больше первоначальной. Измените сумму.");


        return bankNotes;
    }

    @Override
    public void withdrawMoney() throws IOException {

        int initialValue = insertMoney();

        Optional<Integer> minValue = Arrays.stream(BankNotes.values())
                .map(BankNotes::getValue).min(Integer::compareTo);

        Supplier<Stream<Integer>> streamSupplier
                = () -> Stream.of(BankNotes.values())
                .map(BankNotes::getValue);
        List<Integer> withdrawList = new ArrayList<>();
        while (initialValue >= minValue.get()) {
            int finalInitialValue = initialValue;
            int result1 = streamSupplier.get()
                    .filter(x -> x <= finalInitialValue).max(Integer::compareTo)
                    .get();
            initialValue -= result1;
            withdrawList.add(result1);
        }
        if (initialValue > 0) {
            throw new NotValidSumToWithdrawException("Сумму невозможно выдать полностью. Нет купюр.");
        }

        System.out.println("Сумма выдана минимальным количеством банкнот: " + withdrawList);

    }

    @Override
    public void calculateRest() {
        int rest = initialAtmSum - bankNotes;
        if (rest >= 0) {
            System.out.println("Остаток на счету: " + rest);
        } else throw new NoMoneyToWithdrawException("Запрошенная сумма больше первоначальной. Выдача невозможна.");


    }
}
