package com.srini;

import com.kalyani.Account;
import com.kalyani.InsufficientBalanceException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class JDBCTellerImpl implements Teller {
    Account acc = new Account();
    ArrayList<Account> al = new ArrayList<>();
    Iterator it = al.iterator();
    @Override
    public void createAccount(int id, String name, long balance) throws IOException, SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        String query = String.format("insert in to account (id, name, balance) values(%d, %s, %d)", id,name, balance);
        int i = statement.executeUpdate(query);
        statement.close();
        connection.close();
    }

    @Override
    public void deposit(double amount, int accountId) throws IOException, SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        String query = String.format("select balance from account where id = %d", accountId);
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
            int balance = rs.getInt("balance");
            //Statement statement1 = connection.createStatement();
            String updateQuery = String.format("update account set balance = %d where id = %d",balance+amount, accountId);
            int i = statement.executeUpdate(query);
        }
        statement.close();
        connection.close();
    }

    @Override
    public void withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException, SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        String query = String.format("select balance from account where id = %d", accountId);
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
            int balance = rs.getInt("balance");
            if(balance < amount){
                //throw
            }
            //Statement statement1 = connection.createStatement();
            String updateQuery = String.format("update account set balance = %d where id = %d",balance-amount, accountId);
            int i = statement.executeUpdate(query);
        }
        statement.close();
        connection.close();
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

//        BufferedReader fr = new BufferedReader(new FileReader("accounts.txt"));
        BufferedReader fr = new BufferedReader(new FileReader(accountId+".txt"));

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


    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://elmer.db.elephantsql.com:5432/umbutuhs",
                        "umbutuhs", "wpvwb8uzHhVXH4qQJvZXuoDv8Gt9-DBG");
        return connection;
    }
}
