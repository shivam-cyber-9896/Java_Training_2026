package com.shivam.monocept.order.model1;

import java.util.*;
import java.util.concurrent.*;

// ------------------ Order ------------------
class Order {
    int orderId;
    String type;
    String item;

    public Order(int orderId, String type, String item) {
        this.orderId = orderId;
        this.type = type;
        this.item = item;
    }
}

// ------------------ Restaurant ------------------
class Restaurant {
    private int pizza = 5;
    private int burger = 10;

    public synchronized boolean placeOrder(String item) {
        if (item.equalsIgnoreCase("Pizza")) {
            if (pizza > 0) {
                pizza--;
                System.out.println("Inventory updated: Pizza remaining = " + pizza);
                return true;
            } else return false;
        } else {
            if (burger > 0) {
                burger--;
                System.out.println("Inventory updated: Burger remaining = " + burger);
                return true;
            } else return false;
        }
    }
}

// ------------------ Delivery Agent ------------------
class DeliveryAgent {
    public static String assignAgent() {
        int id = (int)(Math.random() * 5 + 1);
        return "Agent-" + id;
    }
}

// ------------------ Runnable ------------------
class OrderTask implements Runnable {
    private Order order;
    private Restaurant restaurant;

    public OrderTask(Order order, Restaurant restaurant) {
        this.order = order;
        this.restaurant = restaurant;
    }

    public void run() {
        System.out.println("[Order-" + order.orderId + "] " + order.type + " Order received");

        try {
            Thread.sleep((int)(Math.random() * 2000));
        } catch (InterruptedException e) {}

        synchronized (restaurant) {
            boolean success = restaurant.placeOrder(order.item);

            if (!success) {
                System.out.println("Order-" + order.orderId + " failed: " + order.item + " out of stock");
                return;
            }
        }

        System.out.println("Processing Order-" + order.orderId + " by " + Thread.currentThread().getName());
        System.out.println("Assigned Delivery: " + DeliveryAgent.assignAgent());
    }
}

// ------------------ Thread Class ------------------
class OrderThread extends Thread {
    private Order order;
    private Restaurant restaurant;

    public OrderThread(Order order, Restaurant restaurant) {
        this.order = order;
        this.restaurant = restaurant;
    }

    public void run() {
        System.out.println("[Order-" + order.orderId + "] " + order.type + " Order received");

        synchronized (restaurant) {
            boolean success = restaurant.placeOrder(order.item);

            if (!success) {
                System.out.println("Order-" + order.orderId + " failed: " + order.item + " out of stock");
                return;
            }
        }

        System.out.println("Processing Order-" + order.orderId + " by " + Thread.currentThread().getName());
        System.out.println("Assigned Delivery: " + DeliveryAgent.assignAgent());
    }
}

// ------------------ Logger Daemon ------------------
class LoggerDaemon extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                System.out.println("Logger: System running smoothly...");
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

// ------------------ Main Menu ------------------
public class FoodDeliveryMenu {

    static List<Order> orders = new ArrayList<>();
    static Restaurant restaurant = new Restaurant();
    static int orderCounter = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 🔹 Start Logger
        LoggerDaemon logger = new LoggerDaemon();
        logger.setDaemon(true);
        logger.start();

        while (true) {
            System.out.println("\n========= 🍔 FOOD DELIVERY MENU =========");
            System.out.println("1. Add Order");
            System.out.println("2. Process Orders");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addOrder(sc);
                    break;

                case 2:
                    processOrders();
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ------------------ Add Order ------------------
    static void addOrder(Scanner sc) {
        System.out.println("\nSelect Order Type:");
        System.out.println("1. VIP");
        System.out.println("2. Regular");
        System.out.println("3. Low");

        int typeChoice = sc.nextInt();
        String type = switch (typeChoice) {
            case 1 -> "VIP";
            case 2 -> "REGULAR";
            default -> "LOW";
        };

        System.out.println("Select Item:");
        System.out.println("1. Pizza");
        System.out.println("2. Burger");

        int itemChoice = sc.nextInt();
        String item = (itemChoice == 1) ? "Pizza" : "Burger";

        Order order = new Order(orderCounter++, type, item);
        orders.add(order);

        System.out.println("✅ Order added successfully!");
    }

    // ------------------ Process Orders ------------------
    static void processOrders() {

        if (orders.isEmpty()) {
            System.out.println("⚠️ No orders to process!");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (Order order : orders) {

            OrderTask task = new OrderTask(order, restaurant);
            Thread thread = new Thread(task);

            // Priority
            if (order.type.equals("VIP"))
                thread.setPriority(Thread.MAX_PRIORITY);
            else if (order.type.equals("LOW"))
                thread.setPriority(Thread.MIN_PRIORITY);
            else
                thread.setPriority(Thread.NORM_PRIORITY);

            executor.submit(thread);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {}

        orders.clear();
        System.out.println("✅ All orders processed!");
    }
}
