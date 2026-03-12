package com.shivam.monocept.viehcaleRegistration.test;



import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.viehcaleRegistration.model1.Bike;
import com.shivam.monocept.viehcaleRegistration.model1.Car;
import com.shivam.monocept.viehcaleRegistration.model1.Vehicle;

public class TransportationSystemTest {

	public static void main(String[] args) throws Exception {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter number of vehicles:");
			int n = scanner.nextInt();
			scanner.nextLine();

			while (n <= 0) {
				System.out.println("Enter valid number of vehicles:");
				n = scanner.nextInt();
				scanner.nextLine();
			}

			Vehicle[] vehicles = new Vehicle[n];
			int index = 0;
			int choice;
			String regex = "^[A-Za-z]{2}[ -]?[0-9]{1,2}[ -]?[A-Za-z]{1,2}[ -]?[0-9]{4}$";
			do {

				System.out.println("\n===== VEHICLE MANAGEMENT SYSTEM =====");
				System.out.println("1. Register Car");
				System.out.println("2. Register Bike");
				System.out.println("3. Display All Vehicles");
				System.out.println("4. Exit");

				System.out.print("Enter choice: ");
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {

				case 1:

					if (index >= n) {
						System.out.println("Vehicle limit reached!");
						throw new ArrayIndexOutOfBoundsException();
					}

					System.out.print("Enter Registration Number: ");
					String reg = scanner.nextLine();

					while (reg == null || reg.trim().isEmpty() || !reg.matches(regex)) {
						System.out.print("Enter valid registration number: ");
						reg = scanner.nextLine();
					}

					System.out.print("Enter Owner Name: ");
					String owner = scanner.nextLine();

					while (owner == null || owner.trim().isEmpty() || !owner.matches("^[A-Za-z ]+$")) {
						System.out.print("Enter valid owner name: ");
						owner = scanner.nextLine();
					}

					System.out.print("Enter Base Charge per Hour: ");
					String baseInput = scanner.nextLine();

					while (baseInput == null || baseInput.trim().isEmpty()
							|| !baseInput.matches("^[1-9]\\d*(\\.\\d+)?$")) {
						System.out.print("Enter valid base charge: ");
						baseInput = scanner.nextLine();
					}

					double baseCharge = Double.parseDouble(baseInput);

					System.out.print("Enter Hours Used: ");
					String hourInput = scanner.nextLine();

					while (hourInput == null || hourInput.trim().isEmpty() || !hourInput.matches("^[1-9]\\d*$")) {
						System.out.print("Enter valid hours: ");
						hourInput = scanner.nextLine();
					}

					int hours = Integer.parseInt(hourInput);

					System.out.print("Enter Number of Seats: ");
					int seats = scanner.nextInt();
					scanner.nextLine();

					vehicles[index++] = new Car(reg, owner, baseCharge, hours, seats);

					System.out.println("Car Registered Successfully");
					break;

				case 2:

					if (index >= n) {
						System.out.println("Vehicle limit reached!");
						throw new ArrayIndexOutOfBoundsException();
					}

					System.out.print("Enter Registration Number: ");
					String reg2 = scanner.nextLine();

					while (reg2 == null || reg2.trim().isEmpty() || !reg2.matches(regex)) {
						System.out.print("Enter valid registration number: ");
						reg2 = scanner.nextLine();
					}

					System.out.print("Enter Owner Name: ");
					String owner2 = scanner.nextLine();

					while (owner2 == null || owner2.trim().isEmpty() || !owner2.matches("^[A-Za-z ]+$")) {
						System.out.print("Enter valid owner name: ");
						owner2 = scanner.nextLine();
					}

					System.out.print("Enter Base Charge per Hour: ");
					String baseInput2 = scanner.nextLine();

					while (baseInput2 == null || baseInput2.trim().isEmpty()
							|| !baseInput2.matches("^[1-9]\\d*(\\.\\d+)?$")) {
						System.out.print("Enter valid base charge: ");
						baseInput2 = scanner.nextLine();
					}

					double baseCharge2 = Double.parseDouble(baseInput2);

					System.out.print("Enter Hours Used: ");
					String hourInput2 = scanner.nextLine();

					while (hourInput2 == null || hourInput2.trim().isEmpty() || !hourInput2.matches("^[1-9]\\d*$")) {
						System.out.print("Enter valid hours: ");
						hourInput2 = scanner.nextLine();
					}

					int hours2 = Integer.parseInt(hourInput2);

					System.out.print("Enter Engine CC: ");
					int cc = scanner.nextInt();
					scanner.nextLine();

					vehicles[index++] = new Bike(reg2, owner2, baseCharge2, hours2, cc);

					System.out.println("Bike Registered Successfully");
					break;

				case 3:

					if (index == 0) {
						System.out.println("No vehicles registered yet.");
					}

					for (int i = 0; i < index; i++) {
						vehicles[i].showDetails();
						vehicles[i].calculateCharge();
						System.out.println("---------------------------");
					}

					break;

				case 4:
					System.out.println("Exiting Program...");
					break;

				default:
					System.out.println("Invalid choice! Try again.");
				}

			} while (choice != 4);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Storage Full");
		}

		catch (InputMismatchException e) {
			System.out.println("Please enter a valid number");
		}

		catch (NumberFormatException e) {
			System.out.println("Number Format Exception");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("Unexpected Exception Handled: " + e);
		}

	}
}