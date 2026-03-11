package com.shivam.monocept.constructor.model1;

public class BankAccount {

	private final long accountNumber;
	private String accountHolderName;
	protected double balance;
	private static long counter = 15425L;
	private final double interestRate = 4.5;

	public BankAccount(String accountHolderName) {
		this(accountHolderName, 0.0);
	}

	public BankAccount(String accountHolderName, double balance) {

		this.accountNumber = ++counter;
		this.accountHolderName=accountHolderName;
		if (balance < 0) {
			System.out.println("You balance Should Not be Negative so we are Creating A 0 balance Account");
			this.balance = 0.0;
		} else {
			this.balance = balance;
		}
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
		}
	}
	
}
