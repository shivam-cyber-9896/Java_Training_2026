package com.shivam.monocept.lsp.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.lsp.model1.*;

public class VehicleTest {

	public static void main(String[] args) {
		
		        Scanner scanner = new Scanner(System.in);

		        List<FuelVehicle> fuelVehicles = new ArrayList<>();
		        List<ElectricVehicle> electricVehicles = new ArrayList<>();

		        while (true) {
		            System.out.println("\n===== VEHICLE MENU =====");
		            System.out.println("1. Add Fuel Car");
		            System.out.println("2. Add Electric Car");
		            System.out.println("3. Start All Vehicles");
		            System.out.println("4. Refuel All Fuel Vehicles");
		            System.out.println("5. Charge All Electric Vehicles");
		            System.out.println("6. Exit");
		            System.out.print("Enter choice: ");
		            String input = scanner.nextLine();

		            while (input == null || input.trim().isEmpty() || !input.matches("\\d+")) {
		                System.out.print("Enter valid choice: ");
		                input = scanner.nextLine();
		            }

		            int choice = Integer.parseInt(input);

		            switch (choice) {

		                case 1:
		                    fuelVehicles.add(new Car());
		                    System.out.println("Fuel Car Added ✅");
		                    break;

		                case 2:
		                    electricVehicles.add(new ElectricCar());
		                    System.out.println("Electric Car Added ⚡");
		                    break;

		                case 3:
		                    System.out.println("\nStarting Fuel Vehicles:");
		                    for (FuelVehicle v : fuelVehicles) {
		                        v.start();
		                    }

		                    System.out.println("\nStarting Electric Vehicles:");
		                    for (ElectricVehicle v : electricVehicles) {
		                        v.start();
		                    }
		                    break;

		                case 4:
		                    System.out.println("\nRefueling Fuel Vehicles:");
		                    for (FuelVehicle v : fuelVehicles) {
		                        v.refuel();
		                    }
		                    break;

		                case 5:
		                    System.out.println("\nCharging Electric Vehicles:");
		                    for (ElectricVehicle v : electricVehicles) {
		                        v.charge();
		                    }
		                    break;

		                case 6:
		                    System.out.println("Exiting...");
		                    return;

		                default:
		                    System.out.println("Invalid choice ");
		                    
		                   
		            }
		        }
	}
}