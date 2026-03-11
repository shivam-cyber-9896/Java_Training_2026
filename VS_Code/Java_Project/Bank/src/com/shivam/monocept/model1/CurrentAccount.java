package com.shivam.monocept.model1;

public class CurrentAccount extends Bank {
    private double overdraftLimit;
    static long accountNoCounter = 192370;
    
    public CurrentAccount( String accountHolderName, double balance, double overdraftLimit) {
        super(++accountNoCounter, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }
}
