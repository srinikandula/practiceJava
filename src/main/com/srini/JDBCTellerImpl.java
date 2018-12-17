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
        String query = String.format("INSERT INTO Bank (Id, Name, Balance) values(%d,'%s', %d)", id,name, balance);
        statement.executeUpdate(query);
        System.out.println("Inserted records into the table...");
        statement.close();
        connection.close();
    }

    @Override
    public void deposit(double amount, int accountId) throws IOException, SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();

        String query = String.format("SELECT Balance from Bank WHERE Id = %d", accountId);
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
            double balance = rs.getDouble("Balance");
            balance = balance+amount;
            String updateQuery = String.format("UPDATE Bank SET Balance = %.2f WHERE Id = %d",balance, accountId);
            statement.executeUpdate(updateQuery);
        }
//        statement1.close();
        statement.close();
        connection.close();
    }

    @Override
    public void withdraw(double amount, int accountId) throws IOException, InsufficientBalanceException, SQLException, ClassNotFoundException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        String query = String.format("SELECT Balance from Bank WHERE Id = %d", accountId);
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
            double balance = rs.getInt("balance");
            if(balance < amount){
                throw new IOException("Insufficient balance");
            }
            balance = balance-amount;
            String updateQuery = String.format("UPDATE Bank SET Balance = %.2f WHERE Id = %d",balance, accountId);
            statement.executeUpdate(updateQuery);
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
    public double getBalance(int accountId) throws IOException, SQLException, ClassNotFoundException {
        int balance =0;
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        String query = String.format("SELECT Balance from Bank WHERE Id = %d", accountId);
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
             balance = rs.getInt("Balance");
        }
        return balance;





/*
//        BufferedReader fr = new BufferedReader(new FileReader("accounts.txt"));
        BufferedReader fr = new BufferedReader(new FileReader(accountId+".txt"));

        String line = fr.readLine();
        while(line != null){
            System.out.println("line..."+line);
            String[] data = line.split("#");
            if(Integer.parseInt(data[0]) == accountId ){
                balance =  Double.parseDouble(data[2]);
                break;
            }
            line = fr.readLine();
        }
*/
    }


    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://elmer.db.elephantsql.com:5432/umbutuhs",
                        "umbutuhs", "wpvwb8uzHhVXH4qQJvZXuoDv8Gt9-DBG");
        return connection;
    }
}
