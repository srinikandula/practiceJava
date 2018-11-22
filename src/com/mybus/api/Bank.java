package com.mybus.api;

import java.io.IOException;
import java.util.Scanner;

public class Bank {
    public static void main(String args[]){
        Teller teller = new TellerImpl();
        while(true){
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Get  Balance");
            System.out.println("Enter your choice");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter account number");
                    int accountId = scanner.nextInt();
                    System.out.println("Enter account name");
                    String name = scanner.next();
                    System.out.println("Enter balance");
                    long balance = scanner.nextLong();
                    try {
                        teller.createAccount(accountId, name, balance);
                    } catch (IOException e) {
                        System.out.println("Failed to create account");
                    }
                    System.out.println("Account has been created");
                    break;
                case 2:
                    //code
                    break;
                case 3:
                    //code
                    break;
            }

        }


    }

}
