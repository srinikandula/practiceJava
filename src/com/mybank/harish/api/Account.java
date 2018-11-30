package com.mybank.harish.api;

public class Account {
    private int id;
    private long balance;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return String.format("#%d#%s#%d\n", this.getId(), this.getName(), this.getBalance());
    }

}
