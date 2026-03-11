package com.shivam.monocept.bankaccount.model1;

public abstract class Bank {
    protected final long accountNo;
    protected final  String accountHolderName;
    protected double balance;
    public Bank(long accountNo, String accountHolderName, double balance) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public long getAccountNo() {
        return accountNo;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }
    public abstract void DisplayDetail();
    public abstract void withdraw(double amount);
}
