package com.shivam.monocept.employee.test;

import com.shivam.monocept.employee.model1.Employee;
import com.shivam.monocept.employee.model1.Input;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = Input.get();

        while (true) {

            System.out.println("\n===== Employee Management Menu =====");
            System.out.println("1. Show Active Employees");
            System.out.println("2. Salary Above Threshold");
            System.out.println("3. Count Employees Department-wise");
            System.out.println("4. Highest Paid Employee");
            System.out.println("5. Names Sorted by Salary (Desc)");
            System.out.println("6. Group by Department");
            System.out.println("7. Average Salary Department-wise");
            System.out.println("8. Add  Employees");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice;

            while (true) {
                System.out.print("Enter your choice: ");
                String input = scanner.nextLine();

                if (input.matches("\\d+")) {
                    choice = Integer.parseInt(input);
                    break;
                }

                System.out.println("Invalid choice! Enter numbers only.");
            }

            switch (choice) {

                case 1:
                    employees.stream()
                            .filter(Employee::isActiveStatus)
                            .forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Enter salary threshold: ");
                    double threshold = scanner.nextDouble();

                    employees.stream()
                            .filter(e -> e.getSalary() > threshold)
                            .forEach(System.out::println);
                    break;

                case 3:
                    Map<String, Long> deptCount = employees.stream()
                            .collect(Collectors.groupingBy(
                                    Employee::getDepartment,
                                    Collectors.counting()
                            ));
                    deptCount.forEach((k, v) ->
                            System.out.println(k + " : " + v));
                    break;

                case 4:
                    employees.stream()
                            .max(Comparator.comparing(Employee::getSalary))
                            .ifPresent(System.out::println);
                    break;

                case 5:
                    employees.stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .map(Employee::getName)
                            .forEach(System.out::println);
                    break;

                case 6:
                    Map<String, List<Employee>> grouped = employees.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment));

                    grouped.forEach((dept, list) -> {
                        System.out.println("\n" + dept);
                        list.forEach(System.out::println);
                    });
                    break;

                case 7:
                    Map<String, Double> avgSalary = employees.stream()
                            .collect(Collectors.groupingBy(
                                    Employee::getDepartment,
                                    Collectors.averagingDouble(Employee::getSalary)
                            ));

                    avgSalary.forEach((k, v) ->
                            System.out.println(k + " : " + v));
                    break;
                case 8:
                	employees = Input.input();
                	break;
                case 9:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}