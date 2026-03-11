package com.shivam.monocept.encapsulation.test;

import java.util.Scanner;

import com.shivam.monocept.encapsulation.model1.InventryMangement;

public class ProductMange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Create Product
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Initial Stock: ");
        int stock = sc.nextInt();

        InventryMangement product = new InventryMangement(name, price, stock);

        int choice;

        do {
            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. View Product Details");
            System.out.println("2. Increase Stock");
            System.out.println("3. Reduce Stock");
            System.out.println("4. Update Price");
            System.out.println("5. Discontinue Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Product Details ---");
                    System.out.println("Product ID: " + product.getProductId());
                    System.out.println("Name: " + product.getProductName());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("Stock: " + product.getStockQuantity());
                    System.out.println("Discontinued: " + product.isDiscontinued());
                    break;

                case 2:
                    System.out.print("Enter quantity to increase: ");
                    int incQty = sc.nextInt();
                    product.increaseStock(incQty);
                    break;

                case 3:
                    System.out.print("Enter quantity to reduce: ");
                    int redQty = sc.nextInt();
                    product.reduceStock(redQty);
                    break;

                case 4:
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    product.updatePrice(newPrice);
                    break;

                case 5:
                    product.discontinueProduct();
                    break;

                case 6:
                    System.out.println("Exiting Inventory System...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
	}

}
