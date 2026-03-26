package com.shivam.monocept.abstractAssingment.test;

import java.util.Scanner;

import com.shivam.monocept.abstractAssingment.model3.*;

public class OrderMenuTest {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.print("Enter number of orders you want to create: ");
			int n = scanner.nextInt();
                   
			while (n <= 0) {
				System.out.print("Please enter valid number of orders: ");
				n = scanner.nextInt();
			}

			Order[] orders = new Order[n];

			int index = 0;
			int choice;

			do {

				System.out.println("\n===== ONLINE ORDER SYSTEM =====");
				System.out.println("1. Create Standard Order");
				System.out.println("2. Create Express Order");
				System.out.println("3. Create International Order");
				System.out.println("4. Process All Orders");
				System.out.println("5. Exit");
				System.out.print("Enter choice: ");

				choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {

				case 1:
				case 2:
				case 3:

					if (index >= n) {
						System.out.println("Order storage full!");
						break;
					}
					System.out.print("Enter Customer Name: ");
					String customer = scanner.nextLine();

					while (customer == null || customer.trim().isEmpty() || !customer.matches("^[A-Za-z ]{3,30}$")) {
						System.out.print("Enter valid Customer Name: ");
						customer = scanner.nextLine();
					}

					System.out.print("Enter Product Name: ");
					String product = scanner.nextLine();

					while (product == null || product.trim().isEmpty() || !product.matches("^[A-Za-z0-9 ]{2,40}$")) {
						System.out.print("Enter valid Product Name: ");
						product = scanner.nextLine();
					}

					System.out.print("Enter Quantity: ");
					String qtyInput = scanner.nextLine();

					while (qtyInput == null || qtyInput.trim().isEmpty() || !qtyInput.matches("^[1-9]\\d*$")) {
						System.out.print("Enter valid Quantity: ");
						qtyInput = scanner.nextLine();
					}

					int qty = Integer.parseInt(qtyInput);
					System.out.print("Enter Price Per Unit: ");
					String priceInput = scanner.nextLine();

					while (priceInput == null || priceInput.trim().isEmpty()
							|| !priceInput.matches("^[1-9]\\d*(\\.\\d+)?$")) {
						System.out.print("Enter valid Price Per Unit: ");
						priceInput = scanner.nextLine();
					}

					double price = Double.parseDouble(priceInput);

					if (choice == 1)
						orders[index] = new StandardOrder(customer, product, qty, price);

					if (choice == 2)
						orders[index] = new ExpressOrder(customer, product, qty, price);

					if(choice==3)
						orders[index] = new InternationalOrder(customer, product, qty, price);

					index++;

					System.out.println("Order Created Successfully!");

					break;

				case 4:

					if (index == 0) {
						System.out.println("No orders available.");
						break;
					}

					for (int i = 0; i < index; i++) {

							orders[i].verifyOrder();
							orders[i].processOrder();
							orders[i].displayOrder();
							System.out.println("---------------------");

					
					}

					break;

				case 5:
					System.out.println("Exiting System...");
					break;

				default:
					System.out.println("Invalid Choice!");

				}

			} while (choice != 5);

		}
		catch (InvalidOrderException e) {

			System.out.println("Order Failed: " + e.getMessage());
		}
		catch (Exception e) {

			System.out.println("Unexpected Error: " + e.getMessage());
		}
	}
}