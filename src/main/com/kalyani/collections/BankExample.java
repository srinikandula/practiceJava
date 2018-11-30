package com.kalyani.collections;

import java.util.Scanner;

public class BankExample{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Teller obj = new TellerImpl();
        int choice = 0;
        int accountId;
        String name;
        double amount;
       while(true){
           System.out.println("1.create an account");
           System.out.println("2.Balance enquiry");
           System.out.println("3.Cash Deposit");
           System.out.println("Select from these...");
           choice = sc.nextInt();
           switch(choice){
               case 1:
                   //create an account
                   System.out.println("Enter account number");
                   accountId = sc.nextInt();
                   System.out.println("Enter account name");
                   name = sc.next();
                   System.out.println("Enter amount");
                    amount = sc.nextDouble();
                   obj.createAccount(accountId,name,amount);
                   break;
               case 2:
                   // get balance
                   System.out.println("Enter account number");
                   accountId = sc.nextInt();
                   System.out.println("The account balance is..."+obj.getBalance(accountId));
                   break;
               case 3:
                   //cash deposit
                   System.out.println("Enter account number");
                   accountId = sc.nextInt();
                   System.out.println("Enter amount");
                   amount = sc.nextDouble();
                   obj.cashDeposit(accountId,amount);
                   break;




           }
       }

    }
}
