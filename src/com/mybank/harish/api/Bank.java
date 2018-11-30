package com.mybank.harish.api;

import java.io.*;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class Bank {
    public static void main(String args[])throws IOException{
        long balance;
        Teller teller = new TellerImpl();
        while(true){
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Get  Balance");
            System.out.println("4. Deposit");
            System.out.println("5. WithDrawl");
            System.out.println("6. Transfer");
            System.out.println("7. EXIT");
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
                    balance = scanner.nextLong();
                    try {
                        teller.createAccount(accountId, name, balance);
                    } catch (IOException e) {
                        System.out.println("Failed to create account");
                    }
                    System.out.println("Account has been created");
                    break;
                case 2:
                    System.out.println("Enter your account number:");
                    String accountid = String.valueOf(scanner.nextInt());
                    File file=new File(accountid+".txt");
                    if(file.delete( )){
                        System.out.println( accountid + " is sucessfully deleted");
                    }
                    else{
                        System.out.println("Account does not Exist");
                    }
                    break;
                case 3:
                    System.out.println("Enter account Number:");
                    accountid = String.valueOf(scanner.nextInt());
                    BufferedReader br = new BufferedReader(new FileReader("bankdata.txt"));
                    String accountInfo = br.readLine();
                    String[] data;
                    data = accountInfo.split("#");
                    System.out.println("Your account balance: " +data[3]);
                    break;
                case 4:
                    System.out.println("Enter account Number:");
                    accountid = String.valueOf(scanner.nextInt());
                    br = new BufferedReader(new FileReader(accountid+".txt"));
                    accountInfo = br.readLine();
                    data = accountInfo.split("#");
                    System.out.println("Your account balance: " +data[2]);
                    balance = Long.parseLong(data[2]);
                    System.out.println("Enter the Amount for Deposit:\n");
                    long newBalance = scanner.nextLong();
                    long updatedBalance;
                    updatedBalance = balance + newBalance;
                    System.out.println(+newBalance+" Sucessfully depoited in your Account");
                    BufferedWriter q=null;
                    FileWriter fstream = new FileWriter(accountid+".txt", true);
                    q = new BufferedWriter(fstream);
                    q.write(updatedBalance+"");
                    if(q!=null){
                        q.close();
                    }
                    break;
                case 5:
                    System.out.println("Enter account Number:");
                    accountId=scanner.nextInt();
                    System.out.println("Enter amount for Withdraw:");
                    double amount=scanner.nextDouble();
                    BufferedReader fr = new BufferedReader(new FileReader(accountId+".txt"));
                    accountInfo = fr.readLine();
                    //id#name#balance
                    data = accountInfo.split("#");
                    balance = Long.parseLong(data[2]);
                    if(balance > amount){
                        balance -= amount;
                        System.out.println(+balance+" is current account balance");
                    } else {
                        System.out.println("Insufficient funds ");
                    }
                    FileWriter fw = new FileWriter(accountId+".txt");
                    accountInfo = String.format("%d#%s#%d", Integer.parseInt(data[0]), data[1], balance);
                    fw.write(accountInfo);
                    fw.close();
                    break;
                case 6:
                    System.out.println("Enter Your account Number:");
                    int sourceAccountId=scanner.nextInt();
                    System.out.println("Enter Destinaton account Number for Transfer:");
                    int destinationAccountId=scanner.nextInt();
                    System.out.println("Enter amount for Transfer:");
                    amount=scanner.nextDouble();
                    BufferedReader frs = new BufferedReader(new FileReader(sourceAccountId+".txt"));
                    String accountInfos = frs.readLine();
                    BufferedReader frd = new BufferedReader(new FileReader(destinationAccountId+".txt"));
                    String accountInfod = frd.readLine();
                    String[] sourceData = accountInfos.split("#");
                    double sourceBalance = Double.parseDouble(sourceData[2]);
                    String[] depositData = accountInfod.split("#");
                    double depositBalance = Double.parseDouble(depositData[2]);

                    if(sourceBalance > amount){
                        sourceBalance -= amount;
                        depositBalance +=amount;
                        System.out.println(amount+" .Rs Sucessfully trasfered to Account.No:"+destinationAccountId+"Account Name:"+depositData[1]);
                    } else {
                        System.out.println("Insufficient funds ");
                    }

                    FileWriter fws = new FileWriter(sourceAccountId+".txt");
                    accountInfos = String.format("%d#%s#%.2f", Integer.parseInt(sourceData[0]), sourceData[1],sourceBalance );
                    fws.write(accountInfos);
                    fws.close();
                    FileWriter fwd = new FileWriter(destinationAccountId+".txt");
                    accountInfod = String.format("%d#%s#%.2f", Integer.parseInt(depositData[0]), depositData[1],depositBalance );
                    fwd.write(accountInfod);
                    fwd.close();
                    break;
                case 7:
                    System.exit(0);
            }

        }


    }

}
