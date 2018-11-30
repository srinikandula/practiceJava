package com.kalyani.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class TellerImpl implements Teller{
    Account acc = new Account();
    ArrayList<Account> al = new ArrayList<>();

    public void createAccount(int accountId,String accName,double amount){
        acc.setAccountId(accountId);
        acc.setAccountName(accName);
        acc.setBalance(amount);
        al.add(acc);
        System.out.println("Account is created successfully...");
    }
    public double getBalance(int accountId){
        System.out.println("accounts in the list..."+al);
        double balance = 0.0;
        Iterator it = al.iterator();
        while(it.hasNext()){
            Account account = (Account)it.next();
            if(account.getAccountId() == accountId){
                balance = account.getBalance();
            }
        }
        return balance;
    }
    public void cashDeposit(int accountId,double amount){
        Iterator it = al.iterator();
        while(it.hasNext()){
            Account acc1 = (Account)it.next();
            if(acc1.getAccountId() == accountId){
                acc1.setBalance(acc1.getBalance() + amount);
                System.out.println("Cash deposited...");
                System.out.println("Account balance is...."+acc1);
            }
        }
    }


}