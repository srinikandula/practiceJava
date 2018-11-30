package com.mybus.api;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Teller {
    Account createAccount(int id, String name, long balance) throws IOException;
    double deposit(double amount, int accountId) throws IOException, InsufficientBalanceException;
    double withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException;
    double transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException, InsufficientBalanceException;
    double getBalance(int accountId) throws IOException;
    boolean deleteAccount(int accountId) throws IOException;
}
