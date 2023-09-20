package main;

import java.util.*;
import java.util.stream.Stream;

public class ATMRunner implements ATM {

    private int bankNotesR;

    HashMap<Integer, Integer> map;

    public ATMRunner(HashMap<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void withdrawMoney(int sumToWithdraw) {
        try {

            bankNotesR = sumToWithdraw;

            Optional<Integer> minValue = map.entrySet()
                    .stream()
                    .min(Comparator.comparingInt(Map.Entry::getKey))
                    .map(Map.Entry::getKey);

            List<Integer> withdrawList = new ArrayList<>();
            while (sumToWithdraw >= minValue.get()) {
                int finalInitialValue = sumToWithdraw;
                if (getStream()
                        .filter(x -> x <= finalInitialValue).count() == 0)
                    break;
                int bankNote = getStream().filter(x -> x <= finalInitialValue)
                        .max(Integer::compareTo).orElse(0);
                sumToWithdraw -= bankNote;
                map.put(bankNote, map.get(bankNote) - 1);
                withdrawList.add(bankNote);
            }
            System.out.println("Сумма выдана минимальным количеством банкнот: " + withdrawList);
        } catch (NullPointerException e) {
            System.out.println("Сумму невозможно выдать полностью. Нет купюр.");
        }

    }

    private Stream<Integer> getStream() {
        return map.
                entrySet().stream().filter(x -> x.getValue() > 0).map(Map.Entry::getKey);
    }

    @Override
    public void depositMoney(HashMap<Integer, Integer> input) {
        for (Map.Entry<Integer, Integer> entry : input.entrySet()) {
            if (entry.getValue() < 0)
                throw new NoMoneyToWithdrawException("Как можно внести отрицательное количество?");
            if (map.containsKey(entry.getKey()))
                map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());
            else
                throw new NoMoneyToWithdrawException("Нет такого номинала " + entry.getKey() + "!");
        }
    }


    @Override
    public void calculateRest() {
        int rest = 0;
        for (Map.Entry<Integer, Integer> x : map.entrySet())
            rest += x.getKey() * x.getValue();

        if (rest >= 0) {
            System.out.println("Остаток на счету: " + rest);
        } else throw new NoMoneyToWithdrawException("Запрошенная сумма больше первоначальной. Выдача невозможна.");


    }
}
