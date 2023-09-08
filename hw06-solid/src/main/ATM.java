package main;

import java.io.IOException;

public interface ATM {
    void getInitialAtmMoney();

    int insertMoney() throws IOException;

    void withdrawMoney() throws IOException;

    void calculateRest();
}
