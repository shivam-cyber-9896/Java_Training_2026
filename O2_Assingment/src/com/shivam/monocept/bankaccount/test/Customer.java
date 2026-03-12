package com.shivam.monocept.bankaccount.test;

import java.security.InvalidKeyException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.shivam.monocept.bankaccount.model1.*;

public class Customer {

    public static void main(String[] argus) {

        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Hi Welcome to the Bank");

			System.out.println("Hi Total No Account Do you want to create");
			int n = scanner.nextInt();

			while (n <= 0) {
			    System.out.println("Hi Total No Account Do you want to create");
			    n = scanner.nextInt();
			}

			Bank[] bank = new Bank[n];
			int choice;
			int index = 0;
      
			do {

			    System.out.println("\n1.Create Saving Account");
			    System.out.println("2.Create Current Account");
			    System.out.println("3.Deposit");
			    System.out.println("4.Withdraw");
			    System.out.println("5.Display Details");
			    System.out.println("6.Exit");

			    System.out.print("Enter choice: ");
			    choice = scanner.nextInt();
			    scanner.nextLine();   

			    switch (choice) {

			    case 1:
			    case 2:

			        System.out.print("Enter name: ");
			        String name = scanner.nextLine();
			        while(name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z]+$"))
			        {
			            System.out.print("Enter valid first name: ");
			            name = scanner.nextLine();
			        }
			        System.out.print("Enter balance: ");
			        String bal = scanner.nextLine();

			        while (bal == null || bal.trim().isEmpty() || !bal.matches("^[1-9]\\d*$")) {
			            System.out.print("Enter balance amount: ");
			            bal = scanner.nextLine();
			        }

			        double balance = Double.parseDouble(bal);

			        if (choice == 2) {

			            System.out.print("Enter overdraft limit: ");
			            String limt = scanner.nextLine();

			            while (limt == null || limt.trim().isEmpty() || !limt.matches("^[1-9]\\d*$")) {
			                System.out.print("Enter over draft limit : ");
			                limt = scanner.nextLine();
			            }

			            double limit = Double.parseDouble(limt);

			            bank[index++] = new CurrentAccount(name, balance, limit);
			            break;
			        }

			        bank[index++] = new SaveingAccount(name, balance);
			        break;

			    case 3:

			        System.out.print("Enter deposit amount: ");
			        String amount = scanner.nextLine();

			        while (amount == null || amount.trim().isEmpty() || !amount.matches("^[1-9]\\d*$")) {
			            System.out.print("Enter deposit amount: ");
			            amount = scanner.nextLine();
			        }

			        double Amount = Double.parseDouble(amount);

			        bank[index - 1].deposit(Amount);  
			        break;

			    case 4:

			        System.out.print("Enter withdraw amount: ");
			        String amount2 = scanner.nextLine();

			        while (amount2 == null || amount2.trim().isEmpty() || !amount2.matches("^[1-9]\\d*$")) {
			            System.out.print("Enter withdraw amount: ");
			            amount2 = scanner.nextLine();
			        }

			        double Amount2 = Double.parseDouble(amount2);

			        bank[index - 1].withdraw(Amount2);   
			        break;

			    case 5:

			        for (int j = 0; j < index; j++) {
			            bank[j].DisplayDetail();
			            System.out.println("------------------");
			        }
			        break;

			    }

			} while (choice != 6);
		} 
        catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
        catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Account limit exceeded");
        }
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

}