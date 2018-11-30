package com.kalyani.collections;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account{
    private int accountId;
    private String accountName;
    private double balance;
    public String toString() {
        return "Account[Name=" + accountName + ",Balance=" + balance +"]";
    }

}