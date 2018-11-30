package com.mybus.api;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String args[]){
        Map<Integer, Account> accounts = new HashMap<>();

        Account sriniAccount = new Account();
        sriniAccount.setId(101);
        sriniAccount.setBalance(100);
        accounts.put(sriniAccount.getId(), sriniAccount);

        Account joeAccount = new Account();
        joeAccount.setId(102);
        joeAccount.setBalance(2000);
        accounts.put(joeAccount.getId(), joeAccount);

        System.out.println(accounts.get(101).getBalance());
    }
}
