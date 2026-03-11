package com.shivam.monocept.inheritance.test;

import java.util.Scanner;

import com.shivam.monocept.imhertaince.model1.*;

public class UserOFAccount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Account Holder Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Initial Balance: ");
		double balance = sc.nextDouble();
		if (name == null || name.trim().isEmpty()) {
			name = sc.nextLine();
		}
		if (balance <= 0) {
			System.out.println("Enter a postive and above o amount ");
			balance = sc.nextDouble();
		}

		BankAccount account = null;

		int choice;

		do {
			System.out.println("\n===== BANK MENU =====");
			System.out.println("1. Create Saveing Account");
			System.out.println("2. Create Current Account");
			System.out.println("3. Display Details");
			System.out.println("4. Deposit");
			System.out.println("5. Withdraw");
			System.out.println("6. Check Balance");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("You are creating a Saving account so minimum Balance limit should Be 1000 ");
				account = new SavingsAccount(name, balance);
				break;

			case 2:
				System.out.println("You are going for a creating a current  account you have to enter a overdraft limit");
				double overDraftLimit = sc.nextDouble();
				account = new CurrentAccount(name, balance, overDraftLimit);
				break;
			case 3:
				account.displayDetails();
				break;
			case 4:
				System.out.println("Enter your amount to be deposit");
				double deposit = sc.nextDouble();
				while (deposit <= 0) {
					System.out.println("enter a vaild amount above 0 and must be postive");
					deposit = sc.nextDouble();
				}
				account.deposit(deposit);
				break;
			case 5:
				System.out.print("Enter withdraw amount: ");
				double withdrawAmount = sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;

			case 6:
				System.out.println("Current Balance: " + account.getBalance());
				break;

			case 7:
				System.out.println("Thank you for banking with us!");
				break;

			default:
				System.out.println("Invalid choice! Try again.");
			}

		} while (choice != 7);

		sc.close();
	}
}
