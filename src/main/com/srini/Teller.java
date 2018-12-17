package com.srini;

import com.kalyani.Account;
import com.kalyani.InsufficientBalanceException;

import java.io.IOException;
import java.sql.SQLException;

public interface Teller {
    void createAccount(int id, String name, long balance) throws IOException, SQLException, ClassNotFoundException;
    void deposit(double amount, int accountId) throws IOException, SQLException, ClassNotFoundException;
<<<<<<< HEAD
    void withdraw(double amount, double accountId) throws IOException, InsufficientBalanceException, SQLException, ClassNotFoundException;
    boolean transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException, ClassNotFoundException, SQLException, InsufficientBalanceException;
    double getBalance(int accountId) throws IOException;
=======
    void withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException, SQLException, ClassNotFoundException;
    boolean transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException;
    double getBalance(int accountId) throws IOException, SQLException, ClassNotFoundException;
>>>>>>> 9d4246615c6f75d2a67ff5c6d92cea3f9d87e58f
}
