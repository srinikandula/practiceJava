package com.mybus.api;

import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;
import static javafx.application.Platform.exit;

public class Bank {
    public static void main(String args[]) throws IOException{
        Teller teller = new TellerImpl();
        while(true){
            out.println("1. Create Account");
            out.println("2. Delete Account");
            out.println("3. Get  Balance");
           out.println("4. withdraw Amount");
            out.println("5. Deposit");
            out.println("6. Transfer Funds");
            out.println("7. for Exit");
            out.println("Enter your choice");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            int accountId;
            int sourceAccountId;
            int destinationAccountId;
            String name;
            long balance;
            double amount;
            switch (choice){
                case 1:
                    out.println("Enter account number");
                     accountId = scanner.nextInt();
                    out.println("Enter account name");
                    name = scanner.next();
                    out.println("Enter balance");
                     balance = scanner.nextLong();
                    try {
                        teller.createAccount(accountId, name, balance);
                    } catch (IOException e) {
                        out.println("Failed to create account");
                    }
                    out.println("Account has been created");
                    break;
                case 2:
                    out.println("Enter account number");
                      accountId=scanner.nextInt();
//                    File file= new File(str.concat(".txt"));
//                    out.println(file);
                    if(teller.deleteAccount(accountId)){
                        out.println("file deleted success fully");
                    }else{
                        out.println("error while deleting a file");
                    }
                    break;
                case 3:
                    System.out.println("enter account number to get balance");
                    accountId=scanner.nextInt();

                        System.out.println(teller.getBalance(accountId));

//                    out.println("enter the account number");
//                    String  str1=Integer.toString(scanner.nextInt());
//                    File file1= new File(str1.concat(".txt"));
//                    FileInputStream in = null;
//                    BufferedReader br =new BufferedReader(new FileReader(file1));
//                    String accountInfo=br.readLine();
//                    String data[]=accountInfo.split("#");
//                    System.out.println("your current balance is:"+data[2]);
                    break;
                case 4: System.out.println("enter account number to with drawl");
                    accountId=scanner.nextInt();
                    System.out.println("enter amount to withdrawl");
                    amount=scanner.nextDouble();

                    try{
                        System.out.println(teller.withdraw(amount,accountId));
                    }catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
//                    out.println("enter the account number");
//                    String str2=Integer.toString(scanner.nextInt());
//                    File file2=new File(str2.concat(".txt"));
//                    BufferedReader br1=new BufferedReader(new FileReader(file2));
//                    String withdraw=br1.readLine();
//                    String data1[]=withdraw.split("#");
//                     Double amount=Double.parseDouble(data1[2]);
//                    System.out.println("enter the money to with drawl:");
//                    Double d=scanner.nextDouble();
//                    if(amount>d){
//                        amount=amount-d;
//                        System.out.println("current balance is"+amount);
//                    }else{
//                        System.out.println("insufficient fumds");
//                    }
                case 5: System.out.println("enter account number to Deposit");
                    accountId=scanner.nextInt();
                    System.out.println("enter amount to Deposit");
                    amount=scanner.nextDouble();

                    try{
                        System.out.println(teller.deposit(amount,accountId));
                    }catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 6: System.out.println("enter your account number");
                    sourceAccountId=scanner.nextInt();
                    System.out.println("enter amount to transfer");
                    amount=scanner.nextDouble();
                    System.out.println("enter beneficiary account number");
                    destinationAccountId=scanner.nextInt();
                    try{
                        System.out.println(teller.transfer(sourceAccountId,destinationAccountId,amount));
                    }catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
            }

        }


    }

}
