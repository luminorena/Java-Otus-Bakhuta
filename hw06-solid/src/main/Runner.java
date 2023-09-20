package main;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        HashMap<Integer, Integer> initMap = new HashMap<>();
        initMap.put(500, 30);
        initMap.put(200, 4);
        initMap.put(50, 45);
        ATMRunner atmRunner = new ATMRunner(initMap);

        HashMap<Integer, Integer> inputMap = new HashMap<>();
        inputMap.put(500, 3);
        inputMap.put(200, 4);
        inputMap.put(50, 1);
        atmRunner.depositMoney(inputMap);

        atmRunner.withdrawMoney(2000);
        atmRunner.calculateRest();

    }
}
