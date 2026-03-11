package com.shivam.monocept.abstractlearning.test;
import java.util.Scanner;
import com.shivam.monocept.abstractlearning.model2.*;

public class PatientTest {
	public static void main(String[] argus) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number of Beds Is available at Hospital ");
		int n = scanner.nextInt();
		while (n <= 0) {
			System.out.println("Enter a Number Should be postive");
			n = scanner.nextInt();
		}
		Patient[] patient = new Patient[n];
		int count = 0;
		int choice;
		scanner.nextLine();
		do {
			System.out.println("\n======Hospital Billing SYSTEM ======");
			System.out.println("1. In Patient");
			System.out.println("2. out Patient");
			System.out.println("3. Emergency Patient");
			System.out.println("4. Process All Payments");
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
				 System.out.print("Enter Patient Name: ");
                 String name1 = scanner.nextLine();
                 while (name1 == null 
                	        || name1.trim().isEmpty() 
                	        || !name1.trim().matches("^[A-Za-z]+( [A-Za-z]+)?$")) {

                	    System.out.print("Enter valid Name (Only letters, single space allowed): ");
                	    name1 = scanner.nextLine();
                	}
                 System.out.print("Enter Room Charges: ");
                 
               String roomCharges = scanner.nextLine();
                 while (roomCharges == null 
                	        || roomCharges.trim().isEmpty() 
                	        || !roomCharges.trim().matches("^[1-9][0-9]*$")) {

                	    System.out.print("Enter valid Amount (positive number only): ");
                	    roomCharges = scanner.nextLine();
                	}
                 patient[count++]=new InPatient(name1,roomCharges);
                break;
			case 2:
				if (n == count) {
					System.out.println("Memory Full ");
					return;

				}
			


                System.out.print("Enter Patient Name: ");
                String name2 = scanner.nextLine();
                while (name2 == null 
                        || name2.trim().isEmpty() 
                        || !name2.trim().matches("^[A-Za-z]+( [A-Za-z]+)?$")) {

                    System.out.print("Enter valid Name (Only letters, single space allowed): ");
                    name2 = scanner.nextLine();
                }
                System.out.print("Enter Consultation Fee: ");
                String fee = scanner.nextLine();
                while (fee == null 
                        || fee.trim().isEmpty() 
                        || !fee.trim().matches("^[1-9][0-9]*$")) {

                    System.out.print("Enter valid Amount (positive number only): ");
                    fee = scanner.nextLine();
                }
                patient[count++]=new OutPatient(name2,fee);
				break;

			case 3:
				if (n == count) {
					System.out.println("Memory Full ");
					return;

				}
				  System.out.print("Enter Patient Name: ");
                  String name3 = scanner.nextLine();
                  while (name3 == null 
                	        || name3.trim().isEmpty() 
                	        || !name3.trim().matches("^[A-Za-z]+( [A-Za-z]+)?$")) {

                	    System.out.print("Enter valid Name (Only letters, single space allowed): ");
                	    name3 = scanner.nextLine();
                	}
                  System.out.print("Enter Emergency Charges: ");
                  String emergencyFee =scanner.nextLine();
				
                  while (emergencyFee == null 
                	        || emergencyFee.trim().isEmpty() 
                	        || !emergencyFee.trim().matches("^[1-9][0-9]*$")) {

            
                	  System.out.print("Enter valid Amount (positive number only): ");
                	    emergencyFee = scanner.nextLine();
                	}
                  patient[count++]=new EmergencyPatient(name3,emergencyFee);
				break;

			case 4:
				System.out.println("\nProcessing All Payments...\n");

				for (int i = 0; i < count; i++) {
					patient[i].generateBill();
					
				}
				break;

			case 5:
				System.out.println("Exiting System...");
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 5);

		scanner.close();
	}
	}


