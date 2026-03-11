package com.shivam.monocept.interfacelearning.miniproject.test;
import java.util.Scanner;

import com.shivam.monocept.interfacelearning.miniproject.*;
public class ControllableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        Controllable device = null;
	        int choice;

	        do {
	            System.out.println("\n===== SMART HOME CONTROLLER =====");
	            System.out.println("1. Light");
	            System.out.println("2. Fan");
	            System.out.println("3. TV");
	            System.out.println("4. Speaker");
	            System.out.println("5. Exit");
	            System.out.print("Select Device: ");

	            choice = scanner.nextInt();
	           

	            switch (choice) {

	            case 1:
	                device = new Light();
	                break;

	            case 2:
	                device = new Fan();
	                break;

	            case 3:
	                device = new Tv();
	                break;

	            case 4:
	                device = new speaker();
	                break;

	            case 5:
	                System.out.println("Exiting Smart Home System...");
	                scanner.close();
	                return;

	            default:
	                System.out.println("Invalid Choice!");
	                continue;
	            }

	            // Device Control Menu
	            int action;
	            do {
	                System.out.println("\n--- Device Control Menu ---");
	                System.out.println("1. Turn ON");
	                System.out.println("2. Set Mode");
	                System.out.println("3. Turn OFF");
	                System.out.println("4. Back to Main Menu");
	                System.out.print("Choose Action: ");

	                action = scanner.nextInt();
	                scanner.nextLine();

	                switch (action) {

	                case 1:
	                    device.turnOn();
	                    break;

	                case 2:
	                    
	                    device.setMode();
	                    break;

	                case 3:
	                    device.turnOff();
	                    break;

	                case 4:
	                    System.out.println("Returning to Main Menu...");
	                    break;

	                default:
	                    System.out.println("Invalid Action!");
	                }

	            } while (action != 4);

	        } while (choice != 5);
	}

}
