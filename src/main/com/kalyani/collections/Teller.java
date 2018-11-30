package com.kalyani.collections;

public interface Teller{
    void createAccount(int accountId,String accName,double amount);

    double getBalance(int accountId) throws Exception;

    void cashDeposit(int accountId, double amount);
}