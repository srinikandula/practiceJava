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
            if(i !=1){
                throw new RuntimeException("Invalid account for deposit");
            }
        }
        statement.close();
        connection.close();
    }


    public void deposit(Connection connection, double amount, int accountId) throws IOException, SQLException, ClassNotFoundException {
        Statement statement = connection.createStatement();
        String query = String.format("select balance from account where id = %d", accountId);
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
            int balance = rs.getInt("balance");
            //Statement statement1 = connection.createStatement();
            String updateQuery = String.format("update account set balance = %d where id = %d",balance+amount, accountId);
            int i = statement.executeUpdate(query);
            if(i !=1){
                throw new RuntimeException("Invalid account for deposit");
            }
        }
        statement.close();
    }

    @Override
    public void withdraw(double amount, double accountId) throws IOException, InsufficientBalanceException, SQLException, ClassNotFoundException {
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

    public void withdraw(Connection connection, double amount, double accountId) throws IOException, InsufficientBalanceException, SQLException, ClassNotFoundException {
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
    }

    @Override
    public boolean transfer(int sourceAccountId, int destinationAccountId, double amount) throws ClassNotFoundException, SQLException, InsufficientBalanceException, IOException {
        Connection connection = createConnection();
        try {
            withdraw(connection , sourceAccountId, amount);
            deposit(connection, amount, destinationAccountId);
        }catch (Exception e){
            connection.rollback();
        }
        connection.commit();
        connection.close();
        return true;
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
