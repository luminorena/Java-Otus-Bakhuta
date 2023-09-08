package main;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        ATMRunner atmRunner = new ATMRunner();
        atmRunner.getInitialAtmMoney();
        atmRunner.withdrawMoney();
        atmRunner.calculateRest();
    }
}
