package com.shivam.monocept.bankaccount.model1;

public class SaveingAccount  extends Bank{
	 static long accountNoCounter = 2356;
	public SaveingAccount(String accountHolderName, double balance) {
		super(++accountNoCounter, accountHolderName, balance);
		
	}
	public void DisplayDetail() {
		   System.out.println("Showing Detail Of Custmor Of Saveing Account");
		   System.out.println("Account Holder Name"+accountHolderName);
		   System.out.println("Account Number"+accountNo);
		   System.out.println("Balance "+balance);
	   } 
	public void withdraw(double amount) {
        if (balance>amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
       
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }
}
