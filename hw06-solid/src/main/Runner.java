package main;

public class Runner {
    public static void main(String[] args)  {
        ATMRunner atmRunner = new ATMRunner(1200);
        atmRunner.withdrawMoney(750);
        atmRunner.calculateRest();
    }
}
