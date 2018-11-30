package com.kalyani;

import java.io.IOException;

public interface Teller {
    Account createAccount(int id, String name, long balance) throws IOException;
    Account deposit(double amount, int accountId) throws IOException;
    double withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException;
    boolean transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException;
    double getBalance(int accountId) throws IOException;
}
