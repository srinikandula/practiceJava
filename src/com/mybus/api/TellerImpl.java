package com.mybus.api;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TellerImpl implements Teller {
    Account acc = new Account();
    ArrayList<Account> al = new ArrayList<>();
    Iterator it = al.iterator();
    @Override
    public Account createAccount(int id, String name, long balance) throws IOException {
        Account a = new Account();
        a.setBalance(balance);
        a.setId(id);
        a.setName(name);
        //id#name#balance
        FileWriter fw = new FileWriter("accounts.txt",true);
        fw.write(a.toString());
        fw.close();
        return a;
    }

    @Override
    public Account deposit(double amount, int accountId) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(accountId+".txt"));
        String accountInfo = fr.readLine();
        String[] data = accountInfo.split("#");
        double balance = Double.parseDouble(data[2]);
            balance += amount;
        FileWriter fw = new FileWriter(accountId+".txt");
        accountInfo = String.format("%d#%s#%.2f", Integer.parseInt(data[0]), data[1], balance);
//        System.out.println("info......"+accountInfo);
        fw.write(accountInfo);
        fw.close();
        System.out.println("Successfull...");
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
        accountInfo = String.format("%d#%s#%.2f", Integer.parseInt(data[0]), data[1], balance);
//        System.out.println("info......"+accountInfo);
        fw.write(accountInfo);
        fw.close();
        return balance;
    }

    @Override
    public boolean transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(sourceAccountId+".txt"));
        String accountInfo = fr.readLine();
        String[] sourceAccInfo = accountInfo.split("#");
        double sourceBal = Double.parseDouble(sourceAccInfo[2]);
        double transferAmt = amount;
        BufferedReader fr1 = new BufferedReader(new FileReader(destinationAccountId+".txt"));
        String destInfo = fr1.readLine();
        String[] destAccInfo = destInfo.split("#");
        double destBal = Double.parseDouble(destAccInfo[2]);
        destBal += transferAmt;
        FileWriter fw = new FileWriter(destinationAccountId+".txt");
        accountInfo = String.format("%d#%s#%.2f", Integer.parseInt(destAccInfo[0]), destAccInfo[1], destBal);
        fw.write(accountInfo);
        fw.close();
        sourceBal -= amount;
        FileWriter fw1 = new FileWriter(sourceAccountId+".txt");
        accountInfo = String.format("%d#%s#%.2f", Integer.parseInt(sourceAccInfo[0]), sourceAccInfo[1], sourceBal);
        fw1.write(accountInfo);
        fw1.close();
        return false;
    }

    @Override
    public double getBalance(int accountId) throws IOException {

        BufferedReader fr = new BufferedReader(new FileReader("accounts.txt"));
        String line = fr.readLine();
        double balance =0.0;
        while(line != null){
            System.out.println("line..."+line);
            String[] data = line.split("#");
            if(Integer.parseInt(data[0]) == accountId ){
                balance =  Double.parseDouble(data[2]);
                break;
            }
            line = fr.readLine();
        }
        return balance;
    }
}
