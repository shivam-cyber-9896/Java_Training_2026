package com.shivam.monocept.abstractlearning.test;

import java.util.Scanner;

import com.shivam.monocept.abstractlearning.model1.CreditCardPayment;
import com.shivam.monocept.abstractlearning.model1.Payment;
import com.shivam.monocept.abstractlearning.model1.WalletPayment;
import com.shivam.monocept.abstractlearning.model1.upiPayment;

public class PaymentTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number of Transaction you want To Genrate");
		int n = scanner.nextInt();
		while (n <= 0) {
			System.out.println("Enter a Number of Transaction you want To Genrate in positive number");
			n = scanner.nextInt();
		}
		Payment[] payments = new Payment[n];
		int count = 0;
		int choice;
		scanner.nextLine();
		do {
			System.out.println("\n====== DIGITAL PAYMENT SYSTEM ======");
			System.out.println("1. Credit Card Payment");
			System.out.println("2. UPI Payment");
			System.out.println("3. Wallet Payment");
			System.out.println("4. Process All Payments");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:
				if (n == count) {
					System.out.println("Memory Full ");
					return;

				}
				System.out.print("Enter Card Number: ");
				String cardNo = scanner.nextLine();
				while (!cardNo.matches("^[0-9]{13,19}$")) {
					System.out.println("Plesse enter a vaild card Number of 13 to 19 digit");
					cardNo = scanner.nextLine();
				}
				System.out.print("Enter Amount: ");
				String ccAmount = scanner.nextLine();
				while (ccAmount == null || ccAmount.trim().isEmpty() || !ccAmount.trim().matches("^[1-9][0-9]*$")) {

					System.out.print("Enter valid Amount: ");
					ccAmount = scanner.nextLine();
				}
				payments[count++] = new CreditCardPayment(cardNo, ccAmount);
				System.out.println("Credit Card Payment Added!");
				break;

			case 2:
				if (n == count) {
					System.out.println("Memory Full ");
					return;

				}
				System.out.print("Enter UPI ID: ");
				String upiId = scanner.nextLine();
				while (!upiId.matches("^[a-zA-Z0-9._-]{2,256}@[a-zA-Z]{2,64}$")) {
					System.out.print(" please enter  a vaild  UPI ID 9876543210@paytm: ");
					upiId = scanner.nextLine();
				}
				System.out.print("Enter Amount: ");
				String upiAmount = scanner.nextLine();
				while (upiAmount == null || upiAmount.trim().isEmpty() || !upiAmount.trim().matches("^[1-9][0-9]*$")) {
					System.out.print("Enter Amount is vaild: ");
					upiAmount = scanner.nextLine();

				}
				payments[count++] = new upiPayment(upiId, upiAmount);
				System.out.println("UPI Payment Added!");
				break;

			case 3:
				if (n == count) {
					System.out.println("Memory Full ");
					return;

				}
				System.out.print("Enter Wallet ID: ");
				String walletId = scanner.nextLine();
				while (!walletId.matches("^[6-9][0-9]{9}$")) {
					System.out.print(" please enter  a vaild  Wallet ID  ");
					walletId = scanner.nextLine();
				}
				System.out.print("Enter Amount: ");
				String walletAmount = scanner.nextLine();
				while (walletAmount == null || walletAmount.trim().isEmpty()
						|| !walletAmount.trim().matches("^[1-9][0-9]*$")) {
					System.out.print("Enter Amount is vaild: ");
					walletAmount = scanner.nextLine();

				}
				payments[count++] = new WalletPayment(walletId, walletAmount);
				System.out.println("Wallet Payment Added!");
				break;

			case 4:
				System.out.println("\nProcessing All Payments...\n");

				for (int i = 0; i < count; i++) {
					payments[i].processPayment();
					payments[i].generateReceipt();
				}
				break;

			case 5:
				System.out.println("Exiting System...");
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 5);

		scanner.close();
	}
}