package com.mybank.harish.api;

import com.mybank.harish.api.Account;
import com.mybank.harish.api.InsufficientBalanceException;
import com.mybank.harish.api.Teller;

import java.io.*;

public class TellerImpl implements Teller {
    @Override
    public Account createAccount(int id, String name, long balance) throws IOException {
        Account a = new Account();
        a.setBalance(balance);
        a.setId(id);
        a.setName(name);
        //id#name#balance
        FileWriter fw = new FileWriter("bankdata.txt",true);
        fw.write(a.toString());
        fw.close();
        return a;
    }

    @Override
    public Account deposit(double amount, int accountId) {
        return null;
    }

    @Override
    public double withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException {
        BufferedReader fr = new BufferedReader(new FileReader(accountId+".txt"));
        String accountInfo = fr.readLine();
        //id#name#balance
        String[] data = accountInfo.split("#");
        double balance = Double.parseDouble(data[2]);
        if(balance > amount){
            balance -= amount;
        } else {
            throw new InsufficientBalanceException("Insufficient funds ");
        }
        FileWriter fw = new FileWriter(accountId+".txt");
        accountInfo = String.format("%d#%s#%d", Integer.parseInt(data[0]), data[1], balance);
        fw.write(accountInfo);
        fw.close();
        return balance;
    }

    @Override
    public boolean transfer(int sourceAccountId, int destinationAccountId, double amount) {
        return false;
    }

    @Override
    public double getBalance(int accountId) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(accountId+".txt"));
        String accountInfo = fr.readLine();
        //id#name#balance
        String[] data = accountInfo.split("#");
        return Double.parseDouble(data[2]);
    }
}
