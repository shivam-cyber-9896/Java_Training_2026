package com.shivam.monocept.bankaccount.model1;

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
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }
   public void DisplayDetail() {
	   System.out.println("Showing Detail Of Custmor");
	   System.out.println("Account Holder Name"+accountHolderName);
	   System.out.println("Account Number"+accountNo);
	   System.out.println(" Account Balance "+balance);
	   System.out.println("OverDraftLimit Of account"+overdraftLimit);
   } 
}
