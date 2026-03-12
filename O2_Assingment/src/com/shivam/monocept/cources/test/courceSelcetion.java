package com.shivam.monocept.cources.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.shivam.monocept.cources.model1.*;

public class courceSelcetion {
	public static void main(String[] argus, Exception ArrayIndexOutOfBoundsException) throws Exception {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter number of students:");
			int n = scanner.nextInt();
			scanner.nextLine();

			while (n <= 0) {
				System.out.println("Enter valid number of students:");
				n = scanner.nextInt();
				scanner.nextLine();
			}

			CourceRegester[] students = new CourceRegester[n];
			int index = 0;
			int choice;

			do {

				System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
				System.out.println("1. Register Regular Student");
				System.out.println("2. Register Scholarship Student");
				System.out.println("3. Display All Students");
				System.out.println("4. Exit");

				System.out.print("Enter choice: ");
				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {

				case 1:

					if (index >= n) {
						System.out.println("Student limit reached!");
						throw ArrayIndexOutOfBoundsException;
					}

					System.out.print("Enter Student Name: ");
					String name = scanner.nextLine();

					while (name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z]+$")) {
						System.out.print("Enter valid name: ");
						name = scanner.nextLine();
					}

					System.out.print("Enter Course Name: ");
					String course = scanner.nextLine();

					while (course == null || course.trim().isEmpty() || !course.matches("^[A-Za-z]+$")) {
						System.out.print("Enter valid course name: ");
						course = scanner.nextLine();
					}

					System.out.print("Enter Fees: ");
					String feesInput = scanner.nextLine();

					while (feesInput == null || feesInput.trim().isEmpty() || !feesInput.matches("^[1-9]\\d*$")) {
						System.out.print("Enter valid fees: ");
						feesInput = scanner.nextLine();
					}

					double fees = Double.parseDouble(feesInput);

					students[index++] = new RegularStudent(name, course, fees);

					System.out.println("Regular Student Registered Successfully");
					break;

				case 2:

					if (index >= n) {
						System.out.println("Student limit reached!");
						throw ArrayIndexOutOfBoundsException;
					}

					System.out.print("Enter Student Name: ");
					String name2 = scanner.nextLine();

					while (name2 == null || name2.trim().isEmpty() || !name2.matches("^[A-Za-z]+$")) {
						System.out.print("Enter valid name: ");
						name2 = scanner.nextLine();
					}

					System.out.print("Enter Course Name: ");
					String course2 = scanner.nextLine();

					while (course2 == null || course2.trim().isEmpty() || !course2.matches("^[A-Za-z]+$")) {
						System.out.print("Enter valid course name: ");
						course2 = scanner.nextLine();
					}

					System.out.print("Enter Fees: ");
					String feesInput2 = scanner.nextLine();

					while (feesInput2 == null || feesInput2.trim().isEmpty() || !feesInput2.matches("^[1-9]\\d*$")) {
						System.out.print("Enter valid fees: ");
						feesInput2 = scanner.nextLine();
					}

					double fees2 = Double.parseDouble(feesInput2);

					System.out.print("Enter Scholarship Percentage: ");
					String per = scanner.nextLine();

					while (per == null || per.trim().isEmpty() || !per.matches("^(100|[1-9]?\\d)$")) {
						System.out.print("Enter valid percentage (0-100): ");
						per = scanner.nextLine();
					}

					double percentage = Double.parseDouble(per);

					students[index++] = new ScholarshipStudent(name2, course2, fees2, percentage);

					System.out.println("Scholarship Student Registered Successfully");
					break;

				case 3:

					if (index == 0) {
						System.out.println("No students registered yet.");
					}

					for (int i = 0; i < index; i++) {
						students[i].showDetail();
						System.out.println("-----------------------------");
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
			System.out.println("Storege Full");
		}
		catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
        }
		catch (NumberFormatException e) {
         System.out.println("Number formet Exception"); 
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("Unexcepted Exception Handled" + e);
		}

	}
}
