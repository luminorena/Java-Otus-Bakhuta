package main;


import java.util.HashMap;

public interface ATM {

    void withdrawMoney(int bankNotes);

    void depositMoney(HashMap<Integer, Integer> map);

    void calculateRest();


}
