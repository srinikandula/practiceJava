package com.mybus.api;

import java.io.*;
import java.util.Scanner;

public class Bank {
    public static void main(String args[]) throws IOException {
        Teller teller = new TellerImpl();
        while(true){
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Get Balance");
            System.out.println("4. Deposit Amount");
            System.out.println("5. Withdraw Amount");
            System.out.println("6. Transfer Amount");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Search By Account");
            System.out.println("10. Exit");
            boolean quit = false;
            do {
                System.out.println("Enter your choice: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                double amount;
                int sourceAccountId;
                int destinationAccountId;
                switch (choice) {
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
//                        System.out.println("Enter your account Number:");
//                        String accountid = String.valueOf(scanner.nextInt());
//                        File file = new File(accountid + ".txt");
//                        if (file.delete()) {
//                            System.out.println(accountid + " is sucessfully deleted");
//                        } else {
//                            System.out.println("Account does not Exist");
//                        }
                        System.out.println("Enter your account Number:");
                        accountId = scanner.nextInt();
                        if (teller.deleteAccount(accountId)) {
                            System.out.println("file deleted success fully");
                        } else {
                            System.out.println("error while deleting a file");
                        }
                        break;
                    case 3:
                        //code
                        System.out.println("Enter your account Number Get balance: ");
                        accountId = scanner.nextInt();
                        try {
                            System.out.println(teller.getBalance(accountId));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
//                        String get = Integer.toString(scanner.nextInt());
//                        File file1 = new File(get.concat(".txt"));
//                        FileInputStream in = null;
//                        BufferedReader br = new BufferedReader(new FileReader(file1));
//                        String accountInfo = br.readLine();
//                        String data[] = accountInfo.split("#");
//                        System.out.println("Your account balance: " +data[2]);
                        break;
                    case 4:
//                      //code
//                        System.out.println("Enter your account Number: ");
//                        String deposit = Integer.toString(scanner.nextInt());
//                        File file2 = new File(deposit.concat(".txt"));
//                        FileInputStream in1 = null;
//                        BufferedReader br1 = new BufferedReader(new FileReader(file2));
//                        String accountInfo1 = br1.readLine();
//                        String data1[] = accountInfo1.split("#");
//                        int s2 = Integer.parseInt(data1[2]);
//
//                        System.out.println("Enter your DepositAmt: ");
//                        long depositAmt = scanner.nextInt();
//                        long deposit1 = s2 + depositAmt;
//                        System.out.println(deposit1);
                        System.out.println("enter account number to with drawl");
                        accountId = scanner.nextInt();
                        System.out.println("enter amount to Deposit");
                        amount = scanner.nextDouble();
                        try {
                            System.out.println(teller.deposit(amount, accountId));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("enter account number to with drawl");
                        accountId = scanner.nextInt();
                        System.out.println("enter amount to withdrawl");
                        amount = scanner.nextDouble();
                        try {
                            System.out.println(teller.withdraw(amount, accountId));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;

                    case 6:
                        System.out.println("enter account number to Transfer");
                        sourceAccountId = scanner.nextInt();
                        System.out.println("Enter amount to transfer");
                        amount = scanner.nextDouble();
                        System.out.println("Enter re account number");
                        destinationAccountId = scanner.nextInt();
                        try {
                            System.out.println(teller.transfer(sourceAccountId, destinationAccountId, amount));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;

                    case 7:
                        break;

                    case 8:
                        break;

                    case 9:
                        break;

                    case 10:
                        quit = true;
                        break;
                }
            } while (!quit);
        }
    }
}
