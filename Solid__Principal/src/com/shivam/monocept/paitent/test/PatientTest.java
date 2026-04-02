package com.shivam.monocept.paitent.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shivam.monocept.paitent.model1.EmailService;
import com.shivam.monocept.paitent.model1.Patient;
import com.shivam.monocept.paitent.model1.PatientReportFormatter;
import com.shivam.monocept.paitent.model1.PatientRepository;
import com.shivam.monocept.paitent.model1.Printer;

public class PatientTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Patient patient = null;
		List<Patient> patients = new ArrayList<>();
		PatientRepository repo = new PatientRepository();
		EmailService email = new EmailService();
		PatientReportFormatter formatter = new PatientReportFormatter();
		Printer printer = new Printer();
		while (true) {
			System.out.println("\n===== Patient Management System =====");
			System.out.println("1. Add Patient");
			System.out.println("2. Save Patient to Database");
			System.out.println("3. Send Email Notification");
			System.out.println("4. Print Patient Report");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {

			case 1:

				System.out.print("Enter Name: ");
				String name = scanner.nextLine();

				while (name == null || name.trim().isEmpty() || !name.matches("^[A-Za-z ]{2,50}$")) {
					System.out.print("Enter valid name: ");
					name = scanner.nextLine();
				}

				System.out.print("Enter Age: ");
				String ageInput = scanner.nextLine();

				while (ageInput == null || ageInput.trim().isEmpty() || !ageInput.matches("\\d+")
						|| Integer.parseInt(ageInput) <= 0 || Integer.parseInt(ageInput) > 120) {

					System.out.print("Enter valid age (1-120): ");
					ageInput = scanner.nextLine();
				}

				int age = Integer.parseInt(ageInput);

				System.out.print("Enter Disease: ");
				String disease = scanner.nextLine();

				while (disease == null || disease.trim().isEmpty() || !disease.matches("^[A-Za-z ]{2,50}$")) {
					System.out.print("Enter valid disease: ");
					disease = scanner.nextLine();
				}

				patient = new Patient(name, age, disease);
				patients.add(patient);
				System.out.println("Patient added successfully!");
				break;

			case 2:
				if (patients.isEmpty()) {
					System.out.println(" Please add a patient first!");
					break;
				}
				for (Patient p : patients) {
					repo.save(p);
				}
				break;

			case 3:
				if (patients.isEmpty()) {
					System.out.println(" Please add a patient first!");
					break;
				}
				for (Patient p : patients) {
					email.sendEmail(p);
				}
				break;

			case 4:
				if (patients.isEmpty()) {
					System.out.println(" Please add a patient first!");
					break;
				}
				for (Patient p : patients) {
					String report = formatter.format(p);
					printer.print(report);
					System.out.println("----------------------");
				}

				break;

			case 5:
				System.out.println("Exiting...");
				scanner.close();
				return;

			default:
				System.out.println(" Invalid choice! Try again.");
			}
		}
	}

}
