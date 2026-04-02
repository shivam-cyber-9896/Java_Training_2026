package com.shivam.monocept.dip.test;

 import java.util.*;

import com.shivam.monocept.dip.model1.*;

public class NotificationTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Order Notification System =====");
            System.out.println("1. Email");
            System.out.println("2. SMS");
            System.out.println("3. Push Notification");
            System.out.println("4. WhatsApp");
            System.out.println("5. All Notifications");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();

            while (input == null || input.trim().isEmpty() || !input.matches("\\d+")) {
                System.out.print("Enter valid choice: ");
                input = scanner.nextLine();
            }

            int choice = Integer.parseInt(input);

            if (choice == 6) {
                System.out.println("Exiting...");
                scanner.close();
                return;
            }

           
            System.out.print("Enter message: ");
            String message = scanner.nextLine();

            while (message == null || message.trim().isEmpty()) {
                System.out.print("Enter valid message: ");
                message = scanner.nextLine();
            }

            List<Notifier> notifiers = new ArrayList<>();

            switch (choice) {
                case 1:
                    notifiers.add(new EmailSender());
                    
                    
                    break;
                case 2:
                    notifiers.add(new SMSSender());
                    break;
                case 3:
                    notifiers.add(new PushNotifier());
                    break;
                case 4:
                    notifiers.add(new WhatsAppNotifier());
                    
                    break;
                case 5:
                    notifiers.add(new EmailSender());
                    notifiers.add(new SMSSender());
                    notifiers.add(new PushNotifier());
                    notifiers.add(new WhatsAppNotifier());
                   
                    
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
                    continue;
            }
            OrderService orderService = new OrderService(notifiers);
            orderService.placeOrder(message);
            
        }
    }
}
