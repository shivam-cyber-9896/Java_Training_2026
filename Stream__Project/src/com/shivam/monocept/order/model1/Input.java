package com.shivam.monocept.order.model1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    static List<Order> orders = new ArrayList<>();
    static int counter=123;
    public static List<Order> input() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter Order Details");

        int orderId = getValidId();
        String customerName = getValidName(scanner);
        String category = getValidCategory(scanner);
        double amount = getValidAmount(scanner);
        OrderStatus status = getValidStatus(scanner);

        orders.add(new Order(orderId, customerName, category, amount, status));

        return orders;
    }
    public static List<Order> addHardcoded() {
        orders.add(new Order(1, "Shivam", "Electronics", 25000, OrderStatus.DELIVERED));
        orders.add(new Order(2, "Rahul", "Clothing", 1500, OrderStatus.PENDING));
        orders.add(new Order(3, "Amit", "Grocery", 800, OrderStatus.SHIPPED));
        orders.add(new Order(4, "Priya", "Electronics", 30000, OrderStatus.PROCESSING));
        orders.add(new Order(5, "Neha", "Fashion", 2000, OrderStatus.CANCELLED));
		return orders;
    }
    private static int getValidId() {
      
       return ++counter;
    }
    private static String getValidName(Scanner scanner) {
        while (true) {
            System.out.print("Customer Name: ");
            String name = scanner.nextLine().trim();

            if (name.matches("[A-Za-z ]+")) {
                return name;
            }

            System.out.println("Invalid Name!");
        }
    }
    private static String getValidCategory(Scanner scanner) {
        while (true) {
            System.out.print("Category: ");
            String category = scanner.nextLine().trim();

            if (category.matches("[A-Za-z ]+")) {
                return category;
            }

            System.out.println("Invalid Category!");
        }
    }
    private static double getValidAmount(Scanner scanner) {
        while (true) {
            System.out.print("Amount: ");
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                double amount = Double.parseDouble(input);

                if (amount > 0) {
                    return amount;
                }
            }

            System.out.println("Invalid Amount!");
        }
    }
    private static OrderStatus getValidStatus(Scanner scanner) {
        while (true) {
            System.out.print("Status (PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED): ");
            String input = scanner.nextLine().toUpperCase();

            try {
                return OrderStatus.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Status!");
            }
        }
    }
}
