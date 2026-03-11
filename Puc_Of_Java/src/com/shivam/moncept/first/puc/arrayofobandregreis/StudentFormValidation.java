package com.shivam.moncept.first.puc.arrayofobandregreis;

import java.util.Scanner;

public class StudentFormValidation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name, rollNo, studentClass;

        // Name Validation
        while (true) {
            System.out.print("Enter Name: ");
            name = sc.nextLine();

            if (!name.matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$")) {
                System.out.println("Invalid Name! (First letter capital, alphabets only)");
                continue;
            }
            break;
        }

        // Roll Number Validation
        while (true) {
            System.out.print("Enter Roll Number: ");
            rollNo = sc.nextLine();

            if (!rollNo.matches("^\\d{3,5}$")) {
                System.out.println("Invalid Roll Number! (3-5 digits only)");
                continue;
            }
            break;
        }

        // Class Validation (PUC1 / PUC2)
        while (true) {
            System.out.print("Enter Class (PUC1/PUC2): ");
            studentClass = sc.nextLine();

            if (!studentClass.matches("(?i)^puc\\s?[12]$")) {
                System.out.println("Invalid Class! Enter PUC1 or PUC2");
                continue;
            }
            break;
        }

        // Final Output
        System.out.println("\n===== Student Details =====");
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNo);
        System.out.println("Class      : " + studentClass.toUpperCase());
    }
}