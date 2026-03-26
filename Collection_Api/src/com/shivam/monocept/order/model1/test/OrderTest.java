package com.shivam.monocept.order.model1.test;

import java.util.Scanner;

import com.shivam.monocept.order.model1.DispachManager;
import com.shivam.monocept.order.model1.Order;
import com.shivam.monocept.order.model1.PriorityOrder;
import com.shivam.monocept.order.model1.RegularOrder;

public class OrderTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DispachManager manager = new DispachManager();

        Order order;

        int choice;

        
        long id = 0;
        String name = "";
        double amount = 0;
        int quantity = 0;

        do {
            System.out.println("\n===== Order Dispatch System =====");
            System.out.println("1. Add Order Detail ");
            System.out.println("2. Choose Order Type");
            System.out.println("3. Dispatch Order");
            System.out.println("4. Display Orders");
            System.out.println("5. Sort by ID");
            System.out.println("6. Sort by Amount");
            System.out.println("7. Sort by Customer Name");
            System.out.println("8. Remove Order by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            
            
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {

            case 1:
               
                System.out.print("Enter Order ID: ");
                String idInput = scanner.nextLine();

                while (idInput.trim().isBlank() || !idInput.matches("\\d+")) {
                    System.out.println("Invalid Order ID (numbers only). Enter again:");
                    idInput = scanner.nextLine();
                }
                id = Long.parseLong(idInput);

               
                System.out.print("Enter Customer Name: ");
                name = scanner.nextLine();

                while (name.trim().isBlank() || !name.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid name (letters only). Enter again:");
                    name = scanner.nextLine();
                }

              
                System.out.print("Enter Quantity: ");
                String qInput = scanner.nextLine();

                while (!qInput.matches("\\d+")) {
                    System.out.println("Invalid quantity (numbers only). Enter again:");
                    qInput = scanner.nextLine();
                }
                quantity = Integer.parseInt(qInput);

               
                System.out.print("Enter Total Amount: ");
                String amtInput = scanner.nextLine();

                while (!amtInput.matches("\\d+(\\.\\d+)?")) {
                    System.out.println("Invalid amount. Enter again:");
                    amtInput = scanner.nextLine();
                }
                amount = Double.parseDouble(amtInput);

                break;

            case 2:
                System.out.println("Choose your order Type");
                System.out.println("1. Priority Order");
                System.out.println("2. Regular Order");

                String typeInput = scanner.nextLine();

                while (!typeInput.matches("[12]")) {
                    System.out.println("Invalid choice. Enter 1 or 2:");
                    typeInput = scanner.nextLine();
                }

                int chosen = Integer.parseInt(typeInput);

                if (chosen == 1) {
                    System.out.println("Priority Order created");
                    order = new PriorityOrder(id, name, amount, quantity);
                } else {
                    System.out.println("Regular Order created");
                    order = new RegularOrder(id, name, amount, quantity);
                }

                manager.addOrder(order);
                break;

            case 3:
                manager.dispachOrder();
                break;

            case 4:
                manager.DisplayOrder();
                break;

            case 5:
                manager.sortById();
                break;

            case 6:
                manager.sortByAmount();
                manager.DisplayOrder();
                break;

            case 7:
                manager.sortByName();
                manager.DisplayOrder();
                break;

            case 8:
                System.out.print("Enter Order ID to remove: ");
                String removeInput = scanner.nextLine();

                while (!removeInput.matches("\\d+")) {
                    System.out.println("Invalid ID. Enter again:");
                    removeInput = scanner.nextLine();
                }

                long removeId = Long.parseLong(removeInput);
                manager.removeDuplicateOrderById(removeId);
                break;

            case 0:
                System.out.println("Exiting system...");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }
}