package com.shivam.monocept.interfacelearning.model3;

public class SavingsAccount implements AccountOperation  {
	 private static long counter = 101L;

	    private final  long AccountNumber;
	    private String accountName;
	    private double balance;
	public SavingsAccount(String name,String balance){
		counter++;
		 this.AccountNumber=counter;
		 this.accountName=name;
		 this.balance=Double.parseDouble(balance);
	}
	@Override
	public void deposit(String Balance) {
		this.balance+=Double.parseDouble(Balance);
		checkBalance();
		
	}

	public double getBalance() {
		return balance;
	}
	
	@Override
	public void withDrow(String Amount) {
		this.balance-=Double.parseDouble(Amount);
		checkBalance();
	}

	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Current Balance is ="+balance);
	}

}
