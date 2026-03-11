package com.shivam.monocept.model1;

public class Bank {
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
    
    
}
