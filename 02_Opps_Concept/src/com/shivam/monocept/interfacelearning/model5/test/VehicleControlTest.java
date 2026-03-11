package com.shivam.monocept.interfacelearning.model5.test;

import java.util.Scanner;

import com.shivam.monocept.interfacelearning.model5.*;

public class VehicleControlTest {
	public static void main(String[] argus) {
		Scanner sc = new Scanner(System.in);
        VehicleControl vehicle = null;

        int choice;

        do {
            System.out.println("\n===== Vehicle Control System =====");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.println("4. Exit");
            System.out.print("Select Vehicle: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    vehicle = new Car();
                    break;

                case 2:
                    vehicle = new Bike();
                    break;

                case 3:
                    vehicle = new Truck();
                    break;

                case 4:
                    System.out.println("Exiting System...");
                    continue;

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

           
            int operation;
            do {
                System.out.println("\n--- Vehicle Operations ---");
                System.out.println("1. Start");
                System.out.println("2. Change Gear");
                System.out.println("3. Stop");
                System.out.println("4. Back to Main Menu");
                System.out.print("Select Operation: ");
                operation = sc.nextInt();

                switch (operation) {

                    case 1:
                        vehicle.start();
                        break;

                    case 2:
                        System.out.print("Enter Gear: ");
                        int gear = sc.nextInt();
                        
                        while(gear<=0||gear>=7) {
                        	System.out.print("Enter  a vaild Gear: ");
                             gear = sc.nextInt();
                        }
                        vehicle.ChangeGear(gear);
                        break;

                    case 3:
                        vehicle.stop();
                        break;

                    case 4:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid Operation!");
                }

            } while (operation != 4);

        } while (choice != 4);

        sc.close();
	
	
	
	}

}
