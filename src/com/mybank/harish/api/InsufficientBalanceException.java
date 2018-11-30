package com.mybank.harish.api;

public class InsufficientBalanceException extends Exception{
    private String message;
    public InsufficientBalanceException(String insufficient_funds_) {
        this.message = insufficient_funds_;
    }
}
