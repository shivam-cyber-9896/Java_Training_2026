package com.shivam.monocept.encapsulation.model1;

import java.util.Scanner;

public class BankAccount {

    private static long counter = 15425L;

    private final long accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double initialBalance) {

        this.accountNumber = ++counter;
        this.accountName = accountName;
        this.balance = initialBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("remaining Balance is ="+balance);
    }

    public void withdraw(double amount) {
        
       
        balance -= amount;
        System.out.println("remaining Balance is ="+balance);
    }
}
