package com.shivam.monocept.inheritance.test;

import java.util.Scanner;
import com.shivam.monocept.imhertaince.model1.*;

public class UseEmployee {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maximum number of employees: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        Employee[] employees = new Employee[size];
        int count = 0;

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE PAYROLL MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Payslips");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    if (count >= size) {
                        System.out.println("Employee storage full!");
                        break;
                    }

                    System.out.println("Select Employee Type:");
                    System.out.println("1. Full Time");
                    System.out.println("2. Part Time");
                    System.out.println("3. Contract");
                    System.out.print("Enter type: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    
                    String id;
                    while (true) {
                        System.out.print("Enter Employee ID: ");
                        id = scanner.nextLine();
                        if (id.matches("[a-zA-Z0-9]+"))
                            break;
                        System.out.println("Invalid ID! Only alphanumeric allowed.");
                    }

                    
                    String name;
                    while (true) {
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();
                        if (!name.isEmpty() && name.matches("[a-zA-Z ]+"))
                            break;
                        System.out.println("Invalid Name! Only alphabets allowed.");
                    }

                    switch (type) {

                        case 1:
                            System.out.print("Enter Basic: ");
                            double basic = scanner.nextDouble();
                            System.out.print("Enter HRA: ");
                            double hra = scanner.nextDouble();
                            System.out.print("Enter DA: ");
                            double da = scanner.nextDouble();

                            employees[count++] =
                                    new FullTimeEmployee(id, name, basic, hra, da);
                            break;

                        case 2:
                            System.out.print("Enter Hours Worked: ");
                            int hours = scanner.nextInt();
                            System.out.print("Enter Hourly Rate: ");
                            double rate = scanner.nextDouble();

                            employees[count++] =
                                    new PartTimeEmployee(id, name, hours, rate);
                            break;

                        case 3:
                            System.out.print("Enter Fixed Amount: ");
                            double fixed = scanner.nextDouble();
                            System.out.print("Enter Tax: ");
                            double tax = scanner.nextDouble();

                            employees[count++] =
                                    new ContractEmployee(id, name, fixed, tax);
                            break;

                        default:
                            System.out.println("Invalid Employee Type!");
                    }

                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No employees added yet.");
                        break;
                    }

                    for (int i = 0; i < count; i++) {
                        employees[i].displayEmployee();
                        System.out.println("------------------");
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No employees available.");
                        break;
                    }

                    for (int i = 0; i < count; i++) {
                        employees[i].printPayslip();  
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