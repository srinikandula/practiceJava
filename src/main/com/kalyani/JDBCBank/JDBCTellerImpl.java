package com.kalyani.JDBCBank;

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
    public void transfer(int sourceAccountId, int destinationAccountId, double amount) throws IOException, ClassNotFoundException, SQLException, InsufficientBalanceException {
        withdraw(amount,sourceAccountId);
        deposit(amount,destinationAccountId);
        System.out.println("Transaction is successfull....");
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
    }


    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://elmer.db.elephantsql.com:5432/umbutuhs",
                "umbutuhs", "wpvwb8uzHhVXH4qQJvZXuoDv8Gt9-DBG");
        return connection;
    }
}
