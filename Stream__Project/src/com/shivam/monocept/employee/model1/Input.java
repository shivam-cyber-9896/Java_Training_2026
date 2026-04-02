package com.shivam.monocept.employee.model1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
	static List<Employee> employees = new ArrayList<>();
    public static List<Employee> input() {

        Scanner scanner = new Scanner(System.in);
        

            System.out.println("\nEnter details for Employee " );

            String name = getValidName(scanner);
            String department = getValidDepartment(scanner);
            double salary = getValidSalary(scanner);
            int experience = getValidInt(scanner, "Experience (years): ");
            boolean status = getValidBoolean(scanner);

            employees.add(new Employee(name, department, salary, experience, status));
			return employees;
      

        
    }
 public static List<Employee> get()
 {
	 employees.add(new Employee("Shivam", "IT", 50000, 2, true));
     employees.add(new Employee("Rahul", "HR", 45000, 3, true));
     employees.add(new Employee("Ankit", "Finance", 60000, 5, false));
     employees.add(new Employee("Priya", "IT", 70000, 4, true));
     employees.add(new Employee("Neha", "Marketing", 55000, 2, false));
     return employees;
 }
    private static String getValidName(Scanner scanner) {
        String name;

        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine().trim();

            if (!name.isEmpty() && name.matches("^[A-Za-z]+( [A-Za-z]+)?$")) {
                return name;
            }

            System.out.println("Invalid Name! Only letters, max one space allowed.");
        }
    }

    
    private static String getValidDepartment(Scanner scanner) {
        String dept;

        while (true) {
            System.out.print("Department: ");
            dept = scanner.nextLine().trim();

            if (!dept.isEmpty() && dept.matches("^[A-Za-z]+$")) {
                return dept;
            }

            System.out.println("Invalid Department! Only letters allowed.");
        }
    }

   
    private static double getValidSalary(Scanner scanner) {

        while (true) {
            System.out.print("Salary: ");

            if (scanner.hasNextDouble()) {
                double salary = scanner.nextDouble();
                scanner.nextLine(); 

                if (salary > 0) {
                    return salary;
                }
            } else {
                scanner.nextLine(); 
            }

            System.out.println("Invalid Salary! Must be a positive number.");
        }
    }

   
    private static int getValidInt(Scanner scanner, String message) {

        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                if (value >= 0) {
                    return value;
                }
            } else {
                scanner.nextLine(); // clear invalid input
            }

            System.out.println("Invalid Input! Enter a valid number.");
        }
    }

  
    private static boolean getValidBoolean(Scanner scanner) {

        while (true) {
            System.out.print("Active Status (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }

            System.out.println("Invalid input! Enter true or false.");
        }
    }
}