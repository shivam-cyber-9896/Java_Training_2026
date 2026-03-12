package com.shivam.monocept.productMangement.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.productMangement.model1.*;

public class ProductSelection {

	public static void main(String[] args) throws Exception {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter number of products:");
			int n = scanner.nextInt();
			scanner.nextLine();

			while (n <= 0) {
				System.out.println("Enter valid number of products:");
				n = scanner.nextInt();
				scanner.nextLine();
			}

			Product[] products = new Product[n];
			int index = 0;
			int choice;

			do {

				System.out.println("\n===== PRODUCT MANAGEMENT SYSTEM =====");
				System.out.println("1. Add Electronic Product");
				System.out.println("2. Add Clothing Product");
				System.out.println("3. Display All Products");
				System.out.println("4. Exit");

				System.out.print("Enter choice: ");
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {

				case 1:

					if (index >= n) {
						System.out.println("Product limit reached!");
						throw new ArrayIndexOutOfBoundsException();
					}

					System.out.print("Enter Product Name: ");
					String name = scanner.nextLine();

					while (name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z ]+$")) {
						System.out.print("Enter valid product name: ");
						name = scanner.nextLine();
					}


					System.out.print("Enter Base Price: ");
					String priceInput = scanner.nextLine();

					while (priceInput == null || priceInput.trim().isEmpty()
							|| !priceInput.matches("^[1-9]\\d*(\\.\\d+)?$")) {
						System.out.print("Enter valid price: ");
						priceInput = scanner.nextLine();
					}

					double price = Double.parseDouble(priceInput);

					System.out.print("Enter Warranty (years): ");
					String warrantyInput = scanner.nextLine();

					while (warrantyInput == null || warrantyInput.trim().isEmpty() || !warrantyInput.matches("^(1[0-5]|[0-9])$")) {
						System.out.print("Enter valid warranty: ");
						warrantyInput = scanner.nextLine();
					}

					double warranty = Double.parseDouble(warrantyInput);

					products[index++] = new ElectronicProduct(name, price, warranty);

					System.out.println("Electronic Product Added Successfully");
					break;

				case 2:

					if (index >= n) {
						System.out.println("Product limit reached!");
						throw new ArrayIndexOutOfBoundsException();
					}

					System.out.print("Enter Product Name: ");
					String name2 = scanner.nextLine();

					while (name2 == null || name2.trim().isEmpty() || !name2.matches("^[A-Za-z ]+$")) {
						System.out.print("Enter valid product name: ");
						name2 = scanner.nextLine();
					}

					

					System.out.print("Enter Base Price: ");
					String priceInput2 = scanner.nextLine();

					while (priceInput2 == null || priceInput2.trim().isEmpty()
							|| !priceInput2.matches("^[1-9]\\d*(\\.\\d+)?$")) {
						System.out.print("Enter valid price: ");
						priceInput2 = scanner.nextLine();
					}

					double price2 = Double.parseDouble(priceInput2);

					System.out.print("Enter Size (S/M/L/XL): ");
					String size = scanner.nextLine();

					while (size == null || size.trim().isEmpty() || !size.matches("^(S|M|L|XL|XXL|s|m|l|xl|xxl)$")) {
						System.out.print("Enter valid size (S/M/L/XL): ");
						size = scanner.nextLine();
						
					}
					size=size.toUpperCase();

					products[index++] = new ClothingProduct(name2, price2, size);

					System.out.println("Clothing Product Added Successfully");
					break;

				case 3:

					if (index == 0) {
						System.out.println("No products added yet.");
					}

					for (int i = 0; i < index; i++) {
						products[i].ShowDetail();
						products[i].CalculatePrice();
						System.out.println("---------------------------");
					}

					break;

				case 4:
					System.out.println("Exiting Program...");
					break;

				default:
					System.out.println("Invalid choice! Try again.");
				}

			} while (choice != 4);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Storage Full");
		}

		catch (InputMismatchException e) {
			System.out.println("Please enter a valid number");
		}

		catch (NumberFormatException e) {
			System.out.println("Number Format Exception");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("Unexpected Exception Handled: " + e);
		}

	}
}
