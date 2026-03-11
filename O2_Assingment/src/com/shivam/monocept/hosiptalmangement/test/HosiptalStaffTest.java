package com.shivam.monocept.hosiptalmangement.test;

import java.util.Scanner;

import com.shivam.monocept.hosiptalmangement.model1.Doctor;
import com.shivam.monocept.hosiptalmangement.model1.Nurse;
import com.shivam.monocept.hosiptalmangement.model1.Staff;

public class HosiptalStaffTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of staff records: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        while (n <= 0) {
            System.out.print("Enter valid number of staff: ");
            n = scanner.nextInt();
            scanner.nextLine();
        }

        Staff[] staff = new Staff[n];
        int index = 0;
        int choice;

        do {

            System.out.println("\n===== HOSPITAL STAFF SYSTEM =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Nurse");
            System.out.println("3. Display Staff Records");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:

                if (index >= n) {
                    System.out.println("Staff limit reached!");
                    break;
                }

                System.out.print("Enter Doctor Name: ");
                String name = scanner.nextLine();

                while (name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z]+$")) {
                    System.out.print("Enter valid name: ");
                    name = scanner.nextLine();
                }

                System.out.print("Enter Department: ");
                String dept = scanner.nextLine();

                while (dept == null || dept.trim().isEmpty() || !dept.matches("^[A-Za-z]+$")) {
                    System.out.print("Enter valid department: ");
                    dept = scanner.nextLine();
                }

                System.out.print("Enter Specialization: ");
                String spec = scanner.nextLine();

                while (spec == null || spec.trim().isEmpty() || !spec.matches("^[A-Za-z ]+$")) {
                    System.out.print("Enter valid specialization: ");
                    spec = scanner.nextLine();
                }

                staff[index++] = new Doctor(name, dept, spec);

                System.out.println("Doctor added successfully!");
                break;

            case 2:

                if (index >= n) {
                    System.out.println("Staff limit reached!");
                    break;
                }

                System.out.print("Enter Nurse Name: ");
                String name2 = scanner.nextLine();

                while (name2 == null || name2.trim().isEmpty() || !name2.matches("^[A-Za-z]+$")) {
                    System.out.print("Enter valid name: ");
                    name2 = scanner.nextLine();
                }

                System.out.print("Enter Department: ");
                String dept2 = scanner.nextLine();

                while (dept2 == null || dept2.trim().isEmpty() || !dept2.matches("^[A-Za-z]+$")) {
                    System.out.print("Enter valid department: ");
                    dept2 = scanner.nextLine();
                }

                System.out.print("Enter Shift (Day/Night): ");
                String shift = scanner.nextLine();

                while (!shift.equalsIgnoreCase("Day") && !shift.equalsIgnoreCase("Night")) {
                    System.out.print("Enter valid shift (Day/Night): ");
                    shift = scanner.nextLine();
                }

                staff[index++] = new Nurse(name2, dept2, shift);

                System.out.println("Nurse added successfully!");
                break;

            case 3:

                if (index == 0) {
                    System.out.println("No staff records found.");
                }

                for (int i = 0; i < index; i++) {
                    staff[i].showDetails();
                    System.out.println("_____________________________");
                }

                break;

            case 4:
                System.out.println("Exiting system...");
                break;

            default:
                System.out.println("Invalid choice!");

            }

        } while (choice != 4);

        scanner.close();
	}

}
