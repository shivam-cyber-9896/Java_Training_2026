package com.shivam.monocept.inheritance.test;

import java.util.Scanner;

import com.shivam.monocept.imhertaince.model1.*;

public class UseNotification {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter maximum number of notifications: ");
		int size = scanner.nextInt();
		scanner.nextLine();
		if (size <= 0) {
			System.out.println("enter a new value");
			size = scanner.nextInt();
		}
		Notification[] notifications = new Notification[size];
		int count = 0;
		int choice;

		do {
			System.out.println("\n===== NOTIFICATION MENU =====");
			System.out.println("1. Send Email");
			System.out.println("2. Send SMS");
			System.out.println("3. Send Push Notification");
			System.out.println("4. View All Notifications");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:
				if (count >= size) {
					System.out.println("Notification storage full!");
					break;
				}

				System.out.print("Enter Recipient to send a email: ");
				String recipient = scanner.nextLine();
				if (!recipient.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
					System.out.println("Enter recipcient type shivam@123");
					recipient = scanner.nextLine();
				}
				System.out.print("Enter Message: ");
				String message = scanner.nextLine();
				notifications[count++] = new EmailNotification(recipient, message);
				break;
			case 2:

				if (count >= size) {
					System.out.println("Notification storage full!");
					break;
				}

				System.out.print("Enter Your number: ");
				recipient = scanner.nextLine();
				if (!recipient.matches("^[6-9]\\\\\\\\d{9}$")) {
					System.out.println("Enter recipcient type");
					recipient = scanner.nextLine();
				}
				System.out.print("Enter Message: ");
				message = scanner.nextLine();

				notifications[count++] = new SMSNotification(recipient, message);
				break;
			case 3:

				if (count >= size) {
					System.out.println("Notification storage full!");
					break;
				}

				System.out.print("Enter a email for  push nofication ");
				recipient = scanner.nextLine();
				if (!recipient.matches("[a-zA-Z0-9]+")){
					System.out.println("Enter recipcient type");
					recipient = scanner.nextLine();
				}
				System.out.print("Enter Message: ");
				message = scanner.nextLine();

				notifications[count++] = new PushNotification(recipient, message);

				System.out.println("Notification created successfully!");
				break;

			case 4:
				if (count == 0) {
					System.out.println("No notifications available.");
					break;
				}

				System.out.println("\n===== SENDING ALL NOTIFICATIONS =====");
				for (int i = 0; i < count; i++) {
					notifications[i].send();
					System.out.println("----------------------");
				}
				break;

			case 5:
				System.out.println("Exiting system...");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 5);

		scanner.close();
	}
}