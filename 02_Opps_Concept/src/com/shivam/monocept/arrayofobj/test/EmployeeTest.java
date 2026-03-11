package com.shivam.monocept.arrayofobj.test;

import java.util.Scanner;

import com.shivam.monocept.arrayofobj.model1.Employee;
import com.shivam.monocept.arrayofobj.model1.FullTimeEmployee;
import com.shivam.monocept.arrayofobj.model1.Intern;
import com.shivam.monocept.arrayofobj.model1.PartTimeEmployee;

public class EmployeeTest {
	static boolean checkStr(String str) {
		
		return str.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$");
		
	}
   static	boolean checkDouble(double d) {
		
		return d>=0;
		
	}
	

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many Employee do uou want to create");
        int numberOfEmployee = scanner.nextInt();

        if(numberOfEmployee<=0) {
            System.out.println("Enter a valid positive number:");
            numberOfEmployee = scanner.nextInt();
        }
        Employee[] employees = new Employee[numberOfEmployee];
        int count = 0;
        int choice;

        do {
            System.out.println("1. Add Full Time Employee");
            System.out.println("2. Add Part Time Employee");
            System.out.println("3. Add Intern");
            System.out.println("4. Display All Employees");
            System.out.println("5. Show Total Employees");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {

            case 1:
            	if(numberOfEmployee==count) {
            		System.out.println("You have Creted Maximun No of Employee");
            		return;
            	}
                System.out.print("Enter Name: ");
                String fName = scanner.nextLine();
                while (!checkStr(fName)) {
                    System.out.print("Please Enter valid Name: ");
                    fName = scanner.nextLine();
                }

                System.out.print("Enter Monthly Salary: ");
                double salary = scanner.nextDouble();
                while (!checkDouble(salary)) {
                    System.out.print("Enter a valid Monthly Salary: ");
                    salary = scanner.nextDouble();
                }

                employees[count++] = new FullTimeEmployee(fName, salary);
                System.out.println("Full Time Employee Added!");
                break;


            case 2:
            	if(numberOfEmployee==count) {
            		System.out.println("You have Creted Maximun No of Employee");
            		return;
            	}
                scanner.nextLine(); 

                System.out.print("Enter Name: ");
                String pName = scanner.nextLine();
                while (!checkStr(pName)) {
                    System.out.print("Please Enter valid Name: ");
                    pName = scanner.nextLine();
                }

                System.out.print("Enter Hours Worked: ");
                int hours = scanner.nextInt();
                while (hours <= 0) {
                    System.out.print("Enter valid Hours Worked: ");
                    hours = scanner.nextInt();
                }

                System.out.print("Enter Hourly Rate: ");
                double rate = scanner.nextDouble();
                while (!checkDouble(rate)) {
                    System.out.print("Enter valid Hourly Rate: ");
                    rate = scanner.nextDouble();
                }

                employees[count++] = new PartTimeEmployee(pName, hours, rate);
                System.out.println("Part Time Employee Added!");
                break;


            case 3:
            	if(numberOfEmployee==count) {
            		System.out.println("You have Creted Maximun No of Employee");
            		return;
            	}
                scanner.nextLine(); 
                System.out.print("Enter Name: ");
                String iName = scanner.nextLine();
                while (!checkStr(iName)) {
                    System.out.print("Please Enter valid Name: ");
                    iName = scanner.nextLine();
                }

                System.out.print("Enter Stipend: ");
                double stipend = scanner.nextDouble();
                while (!checkDouble(stipend)) {
                    System.out.print("Enter valid Stipend: ");
                    stipend = scanner.nextDouble();
                }

                employees[count++] = new Intern(iName, stipend);
                System.out.println("Intern Added!");
                break;
                case 4:
                    System.out.println("\n===== EMPLOYEE DETAILS =====");
                    for (int i = 0; i < count; i++) {
                        employees[i].displayDetails();  // Polymorphism
                    }
                    break;

                case 5:
                    System.out.println("Total Employees Created: "
                            + Employee.getTotalEmployees());
                    break;

                case 6:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        scanner.close();
    }
}
