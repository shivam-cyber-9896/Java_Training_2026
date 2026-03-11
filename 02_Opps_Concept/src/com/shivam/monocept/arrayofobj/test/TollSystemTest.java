package com.shivam.monocept.arrayofobj.test;

import java.util.Scanner;

import com.shivam.monocept.arrayofobj.model1.Truck;
import com.shivam.monocept.arrayofobj.model1.*;

public class TollSystemTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Maximum Vehicles for Today: ");
        int size = sc.nextInt();
        while(size<=0) {
        	System.out.print("Enter a Vaild Size For Today ");
            size = sc.nextInt();
        }
     
        Vehicle[] vehicles = new Vehicle[size];
        int count = 0;
        int choice;
    
        do {
            System.out.println("\n===== TOLL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Car");
            System.out.println("2. Add Truck");
            System.out.println("3. Add Motorcycle");
            System.out.println("4. Process & Calculate Toll");
            System.out.println("5. Show Total Collection");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (count >= size) {
                        System.out.println("Maximum vehicle limit reached!");
                        break;
                    }

                    sc.nextLine(); 
                    System.out.print("Enter Car Number: ");
                    String carNumber = sc.nextLine();
                    while(!carNumber.matches("^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$")) {
                    	System.out.println("Enter a Vaild  number  ");
                    	carNumber = sc.nextLine();
                    }
                    vehicles[count++] = new Vehicle(carNumber);
                    System.out.println("Car Added Successfully!");
                    break;

                case 2:
                    if (count >= size) {
                        System.out.println("Maximum vehicle limit reached!");
                        break;
                    }

                  sc.nextLine();
                    System.out.print("Enter Truck Number: ");
                    String truckNumber = sc.nextLine();
                    while(!truckNumber.matches("^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$")) {
                    	System.out.println("Enter a Vaild  number  ");
                    	truckNumber = sc.nextLine();
                    }
                    System.out.print("Enter Load Weight (tons): ");
                    double weight = sc.nextDouble();

                    vehicles[count++] = new Truck(truckNumber, weight);
                    System.out.println("Truck Added Successfully!");
                    break;

                case 3:
                    if (count >= size) {
                        System.out.println("Maximum vehicle limit reached!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Motorcycle Number: ");
                    String bikeNumber = sc.nextLine();
                    while(!bikeNumber.matches("^[Aa-Zz]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$")) {
                    	System.out.println("Enter a Vaild  number  ");
                    	bikeNumber = sc.nextLine();
                    }
                    vehicles[count++] = new Bike(bikeNumber);
                    System.out.println("Motorcycle Added Successfully!");
                    break; 

                case 4:
                    if (count == 0) {
                        System.out.println("No vehicles to process!");
                        break;
                    }

                    System.out.println("\n--- Processing Toll ---");
                    for (int i = 0; i < count; i++) {
                        double toll = vehicles[i].calculateToll(); 
                        System.out.println("Vehicle: " +
                                vehicles[i].vehicleNumber +
                                " | Toll: ₹" + toll);
                    }
                    break;

                case 5:
                    System.out.println("\nTotal Vehicles Processed: "
                            + Vehicle.totalVehiclesProcessed);
                    System.out.println("Total Toll Collected: ₹"
                            + Vehicle.getTotalTollCollected());
                    break;

                case 0:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}