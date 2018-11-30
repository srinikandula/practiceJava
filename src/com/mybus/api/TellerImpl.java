package com.mybus.api;

import java.io.*;

public class TellerImpl implements Teller {
    @Override
    public Account createAccount(int id, String name, long balance) throws IOException {
        Account a = new Account();
        a.setBalance(balance);
        a.setId(id);
        a.setName(name);
        //id#name#balance
//        FileWriter fw = new FileWriter(id+".txt");
        FileWriter fw = new FileWriter("all.txt", true);
        fw.write("\r\n");
        fw.write(a.toString());
        fw.close();
        return a;
    }

    @Override
    public double deposit(double amount, int accountId) throws IOException, InsufficientBalanceException {

        BufferedReader frd = new BufferedReader(new FileReader(accountId+".txt"));
        String accountInfo = frd.readLine();
        //id#name#balance
        String[] data = accountInfo.split("#");
        double balance = Double.parseDouble(data[2]);
        balance += amount;
        FileWriter fw = new FileWriter(accountId+".txt");
        accountInfo = String.format("%d#%s#%.2f", Integer.parseInt(data[0]), data[1], balance);
        fw.write(accountInfo);
        fw.close();
        return balance;
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
        fw.write(accountInfo);
        fw.close();
        return balance;
    }

    @Override
    public double transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException, InsufficientBalanceException {
        BufferedReader frTr = new BufferedReader(new FileReader(sourceAccountId + ".txt"));
        String accountInfos = frTr.readLine();

        BufferedReader frR = new BufferedReader(new FileReader(destinationAccountId + ".txt"));
        String accountInfod = frR.readLine();
        //id#name#balance

        String[] sourceData = accountInfos.split("#");
        double sourceBalance = Double.parseDouble(sourceData[2]);
        String[] depositData = accountInfod.split("#");
        double depositBalance = Double.parseDouble(depositData[2]);

        if (sourceBalance > amount) {
            sourceBalance -= amount;
            depositBalance += amount;
            System.out.println(depositBalance);
        } else {
            throw new InsufficientBalanceException("Insufficient funds ");
        }

        FileWriter fws = new FileWriter(sourceAccountId + ".txt");
        accountInfos = String.format("%d#%s#%.2f", Integer.parseInt(sourceData[0]), sourceData[1],sourceBalance );
        fws.write(accountInfos);
        fws.close();
        FileWriter fwd = new FileWriter(destinationAccountId + ".txt");
        accountInfod = String.format("%d#%s#%.2f", Integer.parseInt(depositData[0]), depositData[1],depositBalance );
        fwd.write(accountInfod);
        fwd.close();
        return depositBalance ;
    }

    @Override
    public double getBalance(int accountId) throws IOException {
        String accountInfo = "";
        BufferedReader fr = new BufferedReader(new FileReader("all.txt"));
        StringBuffer br = new StringBuffer();
        String line = "";
        while ((line = (fr.readLine())) != null) {
            br.append(line);
        }
        accountInfo = br.toString();
        String[] data = accountInfo.split("#");
        boolean numeric = true;
        double balance = 0;
        for (int i = 0; i < data.length; i++) {
            try {
                Double num = Double.parseDouble(data[i]);
                if (!numeric) {
                    numeric = true;
                }
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if (numeric)
                if (Integer.parseInt(data[i]) == accountId) {
                    System.out.println(data[i + 2]);
                    balance = Double.parseDouble(data[i + 2]);
                }
        }
        return balance;
    }

//    @Override
//    public double getBalance(int accountId) throws IOException {
//        BufferedReader fr = new BufferedReader(new FileReader(accountId+".txt"));
//        String accountInfo = fr.readLine();
//        //id#name#balance
//        String[] data = accountInfo.split("#");
//        return Double.parseDouble(data[2]);
//    }

//    @Override
    public boolean deleteAccount ( int accountId) throws IOException {
        File file = new File(accountId + ".txt");
        if (file.delete()) {
            return true;
        } else {
            return false;
        }
    }
}
