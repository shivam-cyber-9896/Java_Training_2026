package com.shivam.monocept.abstractlearning.test;

import java.util.Scanner;

import com.shivam.monocept.abstractlearning.model3.*;

public class TransportTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number Of Customer Travelling Today");
		int n = scanner.nextInt();
		while (n <= 0) {
			System.out.println("Enter a Number Vaild And positive ");
			n = scanner.nextInt();
		}
			Transport[] Modes=new Transport[n];
			
			int count = 0;
			int choice;
			scanner.nextLine();
			do {
				System.out.println("\n====== Transport Service SYSTEM ======");
				System.out.println("1.Bus Service ");
				System.out.println("2. Metro Service");
				System.out.println("3. Taxi Service");
				System.out.println("4. Book all Services Now");
				System.out.println("5. Exit");
				System.out.print("Enter choice: ");
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					if (n == count) {
						System.out.println("Memory Full ");
						return;

					}
					System.out.println("You are Choseing Bus service today");
					System.out.println("So Base Fare of bus service is applicable is ₹50");
					System.out.println("Plese Enter a number Of Kilometer are you want to travel Today to calculate actual Fare");
					String Travel=scanner.nextLine();
					while (Travel == null 
					        ||Travel.trim().isEmpty() 
					        || !Travel.trim().matches("^[1-9][0-9]*$")) {

					    System.out.print("Enter valid Kilometer (positive number only): ");
					    Travel = scanner.nextLine();
					}
					Modes[count++]=new Bus(Travel);
					break;
				case 2:
					if (n == count) {
						System.out.println("Memory Full ");
						return;

					}
					System.out.println("You are Choseing Metro service today");
					System.out.println("So Base Fare of Metro service is applicable is ₹100");
					System.out.println("Plese Enter a number Of Station are you want to travel Today to calculate actual Fare");
					String Travel2=scanner.nextLine();
					while (Travel2 == null 
					        ||Travel2.trim().isEmpty() 
					        || !Travel2.trim().matches("^[1-9][0-9]*$")) {

					    System.out.print("Enter valid Kilometer (positive number only): ");
					    Travel2 = scanner.nextLine();
					}
					Modes[count++]=new Metro(Travel2);
					break;
				case 3:
					if (n == count) {
						System.out.println("Memory Full ");
						return;

					}
					System.out.println("You are Choseing Bus service today");
					System.out.println("So Base Fare of Taxi service is applicable is ₹200");
					System.out.println("Plese Enter a number Of Kilometer are you want to travel Today to calculate actual Fare");
					String Travel3=scanner.nextLine();
					while (Travel3 == null 
					        ||Travel3.trim().isEmpty() 
					        || !Travel3.trim().matches("^[1-9][0-9]*$")) {

					    System.out.print("Enter valid Kilometer (positive number only): ");
					    Travel3 = scanner.nextLine();
					}
					Modes[count++]=new Taxi(Travel3);
					break;
				case 4:
					System.out.println("\nProcessing  Transport Services...\n");

					for (int i = 0; i < count; i++) {
						
						Modes[i]. PrintTicket();
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
}
