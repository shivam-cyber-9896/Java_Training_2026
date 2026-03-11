package com.shivam.monocept.arrayofobj.test;

import java.util.Scanner;

import com.shivam.monocept.arrayofobj.model1.Course;
import com.shivam.monocept.arrayofobj.model1.OnlineCourse;
import com.shivam.monocept.arrayofobj.model1.RegularCourse;

public class UniversityTest {

   
    static boolean isInvalid(int n) {
        return n <= 0;
    }

    static boolean isInvalid(double n) {
        return n <= 0;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Total No of Courses do you want to Create:");
        int numberOfCourses = scanner.nextInt();

        while (isInvalid(numberOfCourses)) {
            System.out.println("Enter a valid positive number:");
            numberOfCourses = scanner.nextInt();
        }

        Course[] courses = new Course[numberOfCourses];
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== University Courses Selection MENU =====");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. View Fees of All Courses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    if (count >= numberOfCourses) {
                        System.out.println("Course storage full!");
                        break;
                    }

                    System.out.println("Select Learning Type:");
                    System.out.println("1. Regular Course");
                    System.out.println("2. Online Course");
                    System.out.print("Enter type: ");

                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Course Name:");
                    String name = scanner.nextLine();

                    
                    while (name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid Name! Only alphabets allowed.");
                        name = scanner.nextLine();
                    }

                    switch (type) {

                        case 1:
                            System.out.println("Enter Lab Fees:");
                            double labFees = scanner.nextDouble();

                            while (isInvalid(labFees)) {
                                System.out.println("Enter valid Lab Fees:");
                                labFees = scanner.nextDouble();
                            }

                            courses[count++] = new RegularCourse(name, labFees);
                            System.out.println("Regular Course Added Successfully!");
                            break;

                        case 2:
                            System.out.println("Enter Platform Fees:");
                            double platformFees = scanner.nextDouble();

                            while (isInvalid(platformFees)) {
                                System.out.println("Enter valid Platform Fees:");
                                platformFees = scanner.nextDouble();
                            }

                            courses[count++] = new OnlineCourse(name, platformFees);
                            System.out.println("Online Course Added Successfully!");
                            break;

                        default:
                            System.out.println("Invalid Course Type!");
                    }

                    break;

                case 2:
                    System.out.println("\n--- Course List ---");
                    for (int i = 0; i < count; i++) {
                        System.out.println((i+1)+courses[i].getCourseName());
                    }
                    break;

                case 3:
                    System.out.println("\n--- Course Fees ---");
                    for (int i = 0; i < count; i++) {
                        System.out.println(courses[i].getCourseName() +
                                " Fees = " + courses[i].getFinalFee());
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