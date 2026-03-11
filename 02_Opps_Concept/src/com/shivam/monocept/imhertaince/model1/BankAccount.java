package com.shivam.monocept.imhertaince.model1;

public class BankAccount {

	private final long accountNumber;
	private static long counter = 15425L;
	private String holderName;
	private double balance;

	public double getBalance() {
		return balance;
	}

	public BankAccount(String holderName, double balance) {
		this.accountNumber = ++counter;
		this.holderName = holderName;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			return;
		}
		balance += amount;
		System.out.println("Deposited: " + amount);
	}

	public void withdraw(double amount) {

		balance -= amount;
		System.out.println("Withdrawn: " + amount);
	}

	public void displayDetails() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Holder Name: " + holderName);
		System.out.println("Balance: " + balance);

	}

}
