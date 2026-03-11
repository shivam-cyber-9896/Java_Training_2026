package com.shivam.monocept.imhertaince.model1;



public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String AccountholderName, double balance,double overdraftLimit) {
        super( AccountholderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount >= (super.getBalance()+overdraftLimit)) {
           
            System.out.println("Overdraft limit exceeded!");
            return;
        }
        super.withdraw(amount);
        System.out.println("Withdrawn: " + amount);
   
    }
}
