package com.kalyani.JDBCBank;

import com.kalyani.Account;
import com.kalyani.InsufficientBalanceException;

import java.io.IOException;
import java.sql.SQLException;

public interface Teller {
    void createAccount(int id, String name, long balance) throws IOException, SQLException, ClassNotFoundException;
    void deposit(double amount, int accountId) throws IOException, SQLException, ClassNotFoundException;
    void withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException, SQLException, ClassNotFoundException;
    void transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException, ClassNotFoundException, SQLException, InsufficientBalanceException;
    double getBalance(int accountId) throws IOException, SQLException, ClassNotFoundException;
}
