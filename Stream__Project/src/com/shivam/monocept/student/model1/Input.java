package com.shivam.monocept.student.model1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    static List<Student> student = new ArrayList<>();

    public static List<Student> input() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter details for Student");

        String name = getValidName(scanner);
        String standard = getValidStandard(scanner);
        String section = getValidSection(scanner);
        int rollNo = getValidRollno(scanner);
        int marks = getValidMarks(scanner);

        
       
        student.add( new Student( rollNo, name,standard, marks, section));

        return student;
    }

    public static List<Student> addHardcodedStudents() {
        student.add(new Student(1, "Shivam", "10th", 85, "A"));
        student.add(new Student(2, "Rahul", "9th", 78, "B"));
        student.add(new Student(3, "Amit", "12th", 92, "C"));
		return student;
        
    }


    private static String getValidName(Scanner scanner) {
        while (true) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            if (name.matches("[a-zA-Z ]+")) {
                return name;
            }
            System.out.println("Invalid name! Only letters allowed.");
        }
    }

    private static String getValidStandard(Scanner scanner) {
    	while (true) {
    	    System.out.print("Enter Standard (e.g., 10th): ");
    	    String standard = scanner.nextLine();

    	    
    	    if (standard.matches("\\d{1,2}(st|nd|rd|th)")) {
    	        return standard;
    	    }

    	    System.out.println("Invalid Standard! Example: 10th, 1st, 2nd, 3rd");
    	}
    }

    private static String getValidSection(Scanner scanner) {
        while (true) {
            System.out.print("Enter Section (A/B/C): ");
            String section = scanner.nextLine().toUpperCase();

            if (section.matches("[A-C]")) {
                return section;
            }
            System.out.println("Invalid section! Enter A, B, or C.");
        }
    }
    private static int getValidRollno(Scanner scanner) {
        while (true) {
            System.out.print("Enter Roll Number: ");
            String input = scanner.nextLine();

           
            if (input.matches("\\d{1,5}")) {
                return Integer.parseInt(input);
            }

            System.out.println("Invalid Roll Number! Enter numbers only.");
        }
    }
    private static int getValidMarks(Scanner scanner) {
        while (true) {
            System.out.print("Enter Marks (0-100): ");
            String input = scanner.nextLine();

           
            if (input.matches("100|\\d{1,2}")) {
                return Integer.parseInt(input);
            }

            System.out.println("Invalid Marks! Enter value between 0 and 100.");
        }
    }
    }

   

   
    
