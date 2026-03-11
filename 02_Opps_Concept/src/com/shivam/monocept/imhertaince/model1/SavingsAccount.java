package com.shivam.monocept.imhertaince.model1;


public class SavingsAccount extends BankAccount {

    private double minBalance;
    
    public SavingsAccount( String AccountholderName, double balance) {
        super( AccountholderName, balance);
        minBalance=1000;
        
    }

    @Override
    public void withdraw(double amount) {
        if ((super.getBalance() - amount) <= minBalance) {
        	System.out.println("Cannot withdraw. Minimum balance must be maintained: " + minBalance);
           return;
        } 
        super.withdraw(amount);
    }
}
