package com.shivam.monocept.interfacelearning.model6.test;

import java.util.Scanner;

import com.shivam.monocept.interfacelearning.model6.*;

public class ExamEvalutorTest {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	        ExamEvaluator exam = null;

	        int choice;

	        do {
	            System.out.println("\n===== Exam Evaluation System =====");
	            System.out.println("1. Theory Exam");
	            System.out.println("2. Practical Exam");
	            System.out.println("3. Online Quiz");
	            System.out.println("4. Exit");
	            System.out.print("Enter Choice: ");
	            choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    System.out.print("Enter Theory Marks (out of 100): ");
	                    int tMarks = sc.nextInt();
	                    while(tMarks<=0 || tMarks>100) {
	                    	 System.out.print("Enter  vaild Theory Marks (out of 100): ");
	 	                  tMarks = sc.nextInt();
	                    }
	                    
	                    exam = new TheoryExam(tMarks);
	                    break;

	                case 2:
	                    System.out.print("Enter Practical Marks (out of 50): ");
	                    int pMarks = sc.nextInt();
	                    while(pMarks<=0 || pMarks>50) {
		                    System.out.print("Enter vaild Practical Marks (out of 50): ");
		                     pMarks = sc.nextInt();
	                    }
	                    exam = new PracticalExam(pMarks);
	                    break;

	                case 3:
	                    System.out.print("Enter Correct Answers (out of 10): ");
	                    int correct = sc.nextInt();
	                    while(correct<=0 || correct>100) {
	                    	 System.out.print("Enter Correct Answers (out of 10): ");
	 	                      correct = sc.nextInt();
	                    }
	                    exam = new OnlineQuiz(correct);
	                    break;

	                case 4:
	                    System.out.println("Exiting...");
	                    break;

	                default:
	                    System.out.println("Invalid Choice!");
	            }

	            if (exam != null) {
	                exam.evaluateMarks();    
	                exam.calculateGrade();    
	            }

	        } while (choice != 4);

	        sc.close();
	}

}
