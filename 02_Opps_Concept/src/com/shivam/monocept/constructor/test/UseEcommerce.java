package com.shivam.monocept.constructor.test;

import java.util.Scanner;
import com.shivam.monocept.constructor.model1.*;

public class UseEcommerce {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Product product = null;
        Order order = null;

        int choice;

        do {
            System.out.println("\n===== E-COMMERCE MENU =====");
            System.out.println("1. Create Product");
            System.out.println("2. Create Order");
            System.out.println("3. Create Discounted Order");
            System.out.println("4. View Order Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter Product Price: ");
                        double price = scanner.nextDouble();

                        System.out.print("Enter Stock Quantity: ");
                        int stock = scanner.nextInt();

                        product = new Product(price, stock);

                        System.out.println("Product Created Successfully!");
                        System.out.println("Product ID: " + product.getProductId());
                        break;

                    case 2:
                        if (product == null) {
                            System.out.println("Create product first!");
                            break;
                        }

                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();

                        order = new Order(product, quantity);

                        System.out.println("Order Created Successfully!");
                        System.out.println("Order ID: " + order.getOrderId());
                        break;

                    case 3:
                        if (product == null) {
                            System.out.println("Create product first!");
                            break;
                        }

                        System.out.print("Enter Quantity: ");
                        int dQuantity = scanner.nextInt();

                        System.out.print("Enter Discount Percentage: ");
                        double discount = scanner.nextDouble();

                        order = new DiscountedOrder(product, dQuantity, discount);

                        System.out.println("Discounted Order Created Successfully!");
                        System.out.println("Order ID: " + order.getOrderId());
                        break;

                    case 4:
                        if (order == null) {
                            System.out.println("No order created yet!");
                        } else {
                            System.out.println("\n===== ORDER DETAILS =====");
                            System.out.println("Order ID: " + order.getOrderId());
                            System.out.println("Product ID: " + order.getProduct().getProductId());
                            System.out.println("Total Amount: ₹" + order.getTotalAmount());
                        }
                        break;

                    case 5:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        scanner.close();
    }
}