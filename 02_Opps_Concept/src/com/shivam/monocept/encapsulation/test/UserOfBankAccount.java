package com.shivam.monocept.encapsulation.test;

import java.util.Scanner;

import com.shivam.monocept.encapsulation.model1.BankAccount;

public class UserOfBankAccount {

    

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        if(name== null||name.trim().isEmpty()) {
        	name = sc.nextLine();
        }
        if(balance<=0) {
        	System.out.println("Enter a postive and above o amount ");
        	 balance = sc.nextDouble();
        }

        BankAccount account = new BankAccount(name, balance);

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Display Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAccount Number: " + account.getAccountNumber());
                    System.out.println("Account Holder: " + account.getAccountName());
                    System.out.println("Balance: " + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}