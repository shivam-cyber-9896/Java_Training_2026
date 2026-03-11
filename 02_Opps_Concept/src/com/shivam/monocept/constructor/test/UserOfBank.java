package com.shivam.monocept.constructor.test;

import java.util.Scanner;

import com.shivam.monocept.constructor.model1.BankAccount;
import com.shivam.monocept.constructor.model1.PremiumAccount;

public class UserOfBank {
	
	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        BankAccount account = null;

	        int choice;

	        do {
	            System.out.println("\n===== BANK MENU =====");
	            System.out.println("1. Create Normal Account");
	            System.out.println("2. Create Premium Account");
	            System.out.println("3. Deposit");
	            System.out.println("4. Withdraw");
	            System.out.println("5. View Account Details");
	            System.out.println("0. Exit");
	            System.out.print("Enter choice: ");

	            choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {

	                case 1:
	                  
	                    System.out.println("Enter Account Holder Name: ");
	                    String name = scanner.nextLine();
                       if(name==null||name.trim().isEmpty()) {
                    	   System.out.println("Name should not be Empty");
                    	   name = scanner.nextLine();
                       }
	                    System.out.println("Enter Initial Balance: ");
	                    double balance = scanner.nextDouble();

	                    account = new BankAccount(name, balance);
	                    System.out.println("Normal Account Created Successfully!");
	                    break;

	                case 2:
	                	 String pName;
	                	 double pBalance;
	                 if(account.getAccountHolderName()==null||account.getAccountHolderName().trim().isBlank())
	                 {  
	                    System.out.println("Enter Account Holder Name: ");
	                     pName = scanner.nextLine();
	                     if(pName==null||pName.trim().isEmpty()) {
	                    	   System.out.println("Name should not be Empty");
	                    	   name = scanner.nextLine();
	                       }
	                    System.out.println("Enter Initial Balance: ");
	                     pBalance = scanner.nextDouble();
	                    account=new BankAccount(pName,pBalance);
	                 }
	                 else {
	                	 System.out.println("you are converting Simple to permium account");
	                 }
	                    System.out.print("Enter Bonus Amount: ");
	                    double bonus = scanner.nextDouble();
                                   pName=account.getAccountHolderName();
                                   pBalance=account.getBalance();
                                  long pAno=   account.getAccountNumber();
	                    account = new PremiumAccount(pAno, pName, pBalance, bonus);
	                    System.out.println("Premium Account Created Successfully!");
	                    break;

	                case 3:
	                    if (account != null) {
	                        System.out.print("Enter Deposit Amount: ");
	                        double deposit = scanner.nextDouble();
	                        account.deposit(deposit);
	                        System.out.println("Amount Deposited!");
	                    } else {
	                        System.out.println("Create account first!");
	                    }
	                    break;

	                case 4:
	                    if (account != null) {
	                        System.out.print("Enter Withdraw Amount: ");
	                        double withdraw = scanner.nextDouble();
	                        account.withdraw(withdraw);
	                        System.out.println("Amount Withdrawn!");
	                    } else {
	                        System.out.println("Create account first!");
	                    }
	                    break;

	                case 5:
	                    if (account != null) {
	                        System.out.println("\n--- Account Details ---");
	                        System.out.println("Account Holder Name :"+account.getAccountHolderName());
	                        System.out.println("Account Number: " + account.getAccountNumber());
	                        System.out.println("Balance: ₹" + account.getBalance());

	                        if (account instanceof PremiumAccount) {
	                            PremiumAccount pa = (PremiumAccount) account;
	                            System.out.println("Bonus Amount: ₹" + pa.getBonusAmount());
	                        }
	                    } else {
	                        System.out.println("No account found!");
	                    }
	                    break;

	                case 0:
	                    System.out.println("Thank You for Using Bank System!");
	                    break;

	                default:
	                    System.out.println("Invalid Choice!");
	            }

	        } while (choice != 0);

	        scanner.close();
	    }
	}

