package com.shivam.monocept.interfacelearning.test;

import java.util.Scanner;

import com.shivam.monocept.interfacelearning.model2.*;

public class VehicleTest {
	public static void main(String[] argus) {
		Scanner scanner = new Scanner(System.in);
		Vehicle vehicle = null;
		int choice;
		int Choice2;
		do {
			System.out.println("\n===== Vehicle Menu =====");
			System.out.println("1. Car");
			System.out.println("2. Bike");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Choose fuel type (Diesel/Petrol)"
						+"\n"
						+ " Press 1  For Disel:"
						+"\n"
						+ " Press 2 for Petrol :");
				int ch = scanner.nextInt();
				String fuel = "Petrol";;
				while (ch <= 0 || ch >= 3) {
					System.out.print("Choose fuel type (Diesel/Petrol)"
							+"\n"
							+ " Press 1  For Disel:"
							+"\n"
							+ " Press 2 for Petrol :");
					ch = scanner.nextInt();
				}
				if (ch==1) {
					fuel ="Diesel";
				}
				
				vehicle = new Car(fuel);
				System.out.println("Car is created");
				do {
					System.out.println("\n===== Vehicle Menu =====");
					System.out.println("1. Start");
					System.out.println("2. Stop");
					System.out.println("3. Fuel Type");
					System.out.println("4. Exit");
					Choice2 = scanner.nextInt();
					switch (Choice2) {

					case 1:
						vehicle.start();
						break;
					case 2:
						vehicle.stop();
						break;
					case 3:
						System.out.println("Fuel Type" + vehicle.petroltype());
						break;
					case 4:
						System.out.println("Car is Stop And engine off");
						break;
					}
				} while (Choice2 != 4);

				break;

			case 2:
				vehicle = new MoterCycle();

				System.out.println("Car is created");
				do {
					System.out.println("\n===== Vehicle Menu =====");
					System.out.println("1. Start");
					System.out.println("2. Stop");
					System.out.println("3. Fuel Type");
					System.out.println("4. Exit");
					Choice2 = scanner.nextInt();
					switch (Choice2) {

					case 1:
						vehicle.start();
						break;
					case 2:
						vehicle.stop();
						break;
					case 3:

						System.out.println("Fuel Type" + vehicle.petroltype());
						break;
					case 4:
						System.out.println("Car is Stop And engine off");
						break;
					}
				} while (Choice2 != 4);
				break;

			case 3:
				System.out.println("Exiting program...");
				scanner.close();
				return;

			default:
				System.out.println("Invalid choice!");
				
			}

		} while (choice != 3);
	}

}
