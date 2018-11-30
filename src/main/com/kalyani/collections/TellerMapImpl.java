package com.kalyani.collections;

import java.util.HashMap;
import java.util.Map;

public class TellerMapImpl implements Teller{
    Account acc = new Account();
    Map<Integer, Account> accountMap = new HashMap<>();

    public void createAccount(int accountId,String accName,double amount){
        acc.setAccountId(accountId);
        acc.setAccountName(accName);
        acc.setBalance(amount);
        accountMap.put(acc.getAccountId(), acc);
        System.out.println("Account is created successfully...");
    }
    public double getBalance(int accountId){
        Account account = accountMap.get(accountId);
        if(account == null) {
            throw new IllegalArgumentException("No Account found with id "+ accountId);
        }
        return account.getBalance();
    }
    public void cashDeposit(int accountId,double amount){
        Account account = accountMap.get(accountId);
        if(account == null) {
            throw new IllegalArgumentException("No Account found with id "+ accountId);
        }
        account.setBalance(account.getBalance() + amount);
        accountMap.put(account.getAccountId(), account);
    }

    public boolean accountExists(int accountId){
        if(accountMap.get(accountId) != null){
            return true;
        }
        return false;
    }
}