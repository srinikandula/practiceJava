package com.mybus.api;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Teller {
    Account createAccount(int id, String name, long balance) throws IOException;
    Account deposit(double amount, int accountId);
    double withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException;
    boolean transfer(int sourceAccountId, int destinationAccountId, double amount);
    double getBalance(int accountId) throws IOException;
}
