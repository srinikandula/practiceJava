package com.kalyani.JDBCBank;


import com.kalyani.InsufficientBalanceException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank{
    public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException, InsufficientBalanceException {
        Teller teller = new JDBCTellerImpl();
        while(true){
            System.out.println("1. Create Account");
            System.out.println("2. Cash Withdrawl");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Amount Transfer");
            System.out.println("Enter your choice");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            int accountId;
            String name;
            long balance;
            double amount;
            switch (choice){
                case 1:
                    System.out.println("Enter account number");
                    accountId = scanner.nextInt();
                    System.out.println("Enter account name");
                    name = scanner.next();
                    System.out.println("Enter balance");
                    balance = scanner.nextLong();
                    try {
                        teller.createAccount(accountId, name, balance);
                    } catch (IOException e) {
                        System.out.println("Failed to create account");
                    }
                    break;
                case 2:
                    System.out.println("Enter account number");
                    accountId = scanner.nextInt();
                    System.out.println("Enter cash to be withdrawn....");
                    amount = scanner.nextDouble();
                    try {
                        teller.withdraw(amount,accountId);
                    } catch (IOException e) {
                        System.out.println("Failed to create account");
                    }
                    System.out.println("The withdrawn amount is....."+amount);
                    break;
                case 3:
                    System.out.println("Enter account number");
                    accountId = scanner.nextInt();
                    System.out.println("Enter cash to deposit....");
                    amount = scanner.nextDouble();
                    try {
                        teller.deposit(amount,accountId);
                    } catch (IOException e) {
                        System.out.println("Failed to create account");
                    }
                    break;
                case 4:
                    System.out.println("Enter account number");
                    accountId = scanner.nextInt();
                    System.out.println("Your account balance is..."+teller.getBalance(accountId));
                    break;
                case 5:
                    System.out.println("Enter account number");
                    int sourceAccountId = scanner.nextInt();
                    System.out.println("Enter account number to transfer");
                    int  destAccountId = scanner.nextInt();
                    System.out.println("Enter cash to transfer....");
                    amount = scanner.nextDouble();
                    teller.transfer(sourceAccountId, destAccountId, amount);
                    break;
                default:
                    System.out.println();
            }
        }
    }
}
