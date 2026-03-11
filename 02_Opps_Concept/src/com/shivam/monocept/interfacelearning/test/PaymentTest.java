package com.shivam.monocept.interfacelearning.test;

import java.util.Scanner;


import com.shivam.monocept.interfacelearning.model1.*;

public class PaymentTest {
	public static void main(String[] argus) {
		Scanner scanner = new Scanner(System.in);
		String Amount;
		Double Send;
		int choice;
		
		do {
			System.out.println("\n====== DIGITAL PAYMENT SYSTEM ======");
			System.out.println("1. Credit Card Payment");
			System.out.println("2. UPI Payment");
			System.out.println("3. Wallet Payment");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter Amount: ");
				 Amount = scanner.nextLine();
				while (Amount == null || Amount.trim().isEmpty() || !Amount.trim().matches("^[1-9][0-9]*$")) {

					System.out.print("Enter valid Amount: ");
					Amount = scanner.nextLine();
				}
				Send=Double.parseDouble(Amount);
				Payment payment = new CreditCardPayment();
				payment.processPayment(Send);
				break;
			case 2:
				System.out.print("Enter Amount: ");
				 Amount = scanner.nextLine();
				while (Amount == null || Amount.trim().isEmpty() || !Amount.trim().matches("^[1-9][0-9]*$")) {

					System.out.print("Enter valid Amount: ");
					Amount = scanner.nextLine();
				}
				Send=Double.parseDouble(Amount);
				Payment payment1 = new DebitCardPayment();
				payment1.processPayment(Send);
				break;
			case 3:
				System.out.print("Enter Amount: ");
				 Amount = scanner.nextLine();
				while (Amount == null || Amount.trim().isEmpty() || !Amount.trim().matches("^[1-9][0-9]*$")) {

					System.out.print("Enter valid Amount: ");
					Amount = scanner.nextLine();
				}
				Send=Double.parseDouble(Amount);
				Payment payment2 = new CreditCardPayment();
				payment2.processPayment(Send);
				break;
			case 4:
				System.out.println("Exiting System...");
				break;

			default:
				System.out.println("Invalid Choice!");
			
			}
		} while (choice != 4);

	}
}
