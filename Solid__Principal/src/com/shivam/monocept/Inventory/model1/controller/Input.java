package com.shivam.monocept.Inventory.model1.controller;

import java.time.LocalDate;
import java.util.*;

import com.shivam.monocept.Inventory.model1.product.Product;
import com.shivam.monocept.Inventory.model1.product.NonPerishableGoods;
import com.shivam.monocept.Inventory.model1.product.PerishableGoods;

public class Input {

    static List<Product> products;

    static {
        products = new ArrayList<>();

        products.add(new NonPerishableGoods("Rice", 60, 20, 10, 12));
        products.add(new PerishableGoods("Milk", 50, 10, LocalDate.now().plusDays(5), 5));
    }

    public static List<Product> getList() {
        return products;
    }

    public static List<Product> input(String type) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter Product Details");

        String name = getValidName(scanner);
        double price = Double.parseDouble(getValidPrice(scanner));
        int quantity = Integer.parseInt(getValidQuantity(scanner));
        int reorderLevel = Integer.parseInt(getValidReorderLevel(scanner, quantity));

        if (type.equalsIgnoreCase("NON_PERISHABLE")) {

            int warranty = Integer.parseInt(getValidWarranty(scanner));
            products.add(new NonPerishableGoods(name, price, quantity,  warranty,reorderLevel));
            return products;
        } 


            LocalDate expiryDate = getValidDate(scanner);
            products.add(new PerishableGoods(name, price, quantity, expiryDate, reorderLevel));

            return products;
    }

   

    private static String getValidName(Scanner scanner) {
        String name = null;

        while (name == null || !name.matches("[A-Za-z ]+")) {
            System.out.print("Enter name: ");
            name = scanner.nextLine().trim();

            if (!name.matches("[A-Za-z ]+")) {
                System.out.println(" Invalid name! Only letters allowed.");
            }
        }
        return name;
    }

    private static String getValidPrice(Scanner scanner) {
        String price = null;

        while (price == null || !price.matches("\\d+")) {
            System.out.print("Enter price: ");
            price = scanner.nextLine();

            if (!price.matches("\\d+") || Double.parseDouble(price) <= 0) {
                System.out.println(" Invalid price! Enter positive number.");
                price = null;
            }
        }
        return price;
    }

    private static String getValidQuantity(Scanner scanner) {
        String qty = null;

        while (qty == null) {
            System.out.print("Enter quantity: ");
            qty = scanner.nextLine();

            if (!qty.matches("\\d+") || Integer.parseInt(qty) < 0) {
                System.out.println("Invalid quantity! Enter a positive number.");
                qty = null;
            }
        }
        return qty;
    }

    private static String getValidReorderLevel(Scanner scanner, int quantity) {
        String level = null;

        while (level == null) {
            System.out.print("Enter reorder level: ");
            level = scanner.nextLine();

            if (!level.matches("\\d+")) {
                System.out.println("Invalid input! Enter a number.");
                level = null;
                continue;
            }

            int val = Integer.parseInt(level);

            if (val > quantity) {
                System.out.println("Reorder level must be <= quantity!");
                level = null;
            }
        }
        return level;
    }
    

    private static LocalDate getValidDate(Scanner scanner) {
        String input = null;

        while (input == null || !input.matches("[1-9]")) {
            System.out.print("Enter expiry in days (0-9): ");
            input = scanner.nextLine();

            if (!input.matches("[1-9]")) {
                System.out.println(" Enter single digit only!");
                input = null;
            }
        }

        int days = Integer.parseInt(input);
        return LocalDate.now().plusDays(days);
    }

    private static String getValidWarranty(Scanner scanner) {
        String warranty = null;

        while (warranty == null || !warranty.matches("\\d+")) {
            System.out.print("Enter warranty : ");
            warranty = scanner.nextLine();

            if (!warranty.matches("\\d+")) {
                System.out.println("Enter vaild digit only!");
            }
        }
        return warranty;
    }
}