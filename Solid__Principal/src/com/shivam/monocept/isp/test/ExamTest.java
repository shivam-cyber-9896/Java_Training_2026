package com.shivam.monocept.isp.test;

import java.util.Scanner;

import com.shivam.monocept.isp.model1.AIProctor;
import com.shivam.monocept.isp.model1.AdminService;
import com.shivam.monocept.isp.model1.ExamGrader;
import com.shivam.monocept.isp.model1.ExamStarter;
import com.shivam.monocept.isp.model1.QuestionBankManager;
import com.shivam.monocept.isp.model1.StudentExam;
import com.shivam.monocept.isp.model1.TeacherAssigner;
import com.shivam.monocept.isp.model1.TeacherService;

public class ExamTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Exam Management System =====");
            System.out.println("1. Student - Start Exam");
            System.out.println("2. Teacher - Grade Exam");
            System.out.println("3. Teacher - Create Question Bank");
            System.out.println("4. Admin - Assign Teacher");
            System.out.println("5. AI Proctor - Monitor Exam");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            
            while (input == null || input.trim().isEmpty() || !input.matches("\\d+")) {
                System.out.print("Enter valid choice: ");
                input = scanner.nextLine();
            }

            int choice = Integer.parseInt(input);

            switch (choice) {

                case 1:
                    ExamStarter student = new StudentExam();
                    student.startExam();
                    break;

                case 2:
                    ExamGrader teacherGrader = new TeacherService();
                    teacherGrader.gradeExam();
                    break;

                case 3:
                    QuestionBankManager teacherQB = new TeacherService();
                    teacherQB.createQuestionBank();
                    break;

                case 4:
                    TeacherAssigner admin = new AdminService();
                    admin.assignTeacher();
                    break;

                case 5:
                    ExamStarter ai = new AIProctor();
                    ai.startExam();
                    break;

                case 6:
                    System.out.println(" Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}