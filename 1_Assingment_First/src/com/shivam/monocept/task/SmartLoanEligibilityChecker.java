package com.shivam.monocept.task;

import java.util.Scanner;

public class SmartLoanEligibilityChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of applicants: ");
        int n = scanner.nextInt();

        int[] creditScores = new int[n];
        int[] monthlyIncomes = new int[n];
        int[] existingLoans = new int[n];

        System.out.println("Enter credit scores:");
        for (int i = 0; i < n; i++) {
            creditScores[i] = scanner.nextInt();
        }

        System.out.println("Enter monthly incomes:");
        for (int i = 0; i < n; i++) {
            monthlyIncomes[i] = scanner.nextInt();
        }

        System.out.println("Enter number of existing loans:");
        for (int i = 0; i < n; i++) {
            existingLoans[i] = scanner.nextInt();
        }

        int approvals = 0;
        int rejections = 0;
        int bestApplicantIndex = -1;

        for (int i = 0; i < n; i++) {

            System.out.print("Applicant " + i + ": ");

           
            if (creditScores[i] < 600 ||
                monthlyIncomes[i] < 25000 ||
                existingLoans[i] >= 3) {

                System.out.println("Rejected");
                rejections++;

            } else {

                approvals++;

                if (creditScores[i] >= 800 && monthlyIncomes[i] > 100000) {
                    System.out.println("Instant Approval");
                } else {
                    System.out.println("Standard Review");
                }

                
                if (bestApplicantIndex == -1 ||
                    creditScores[i] > creditScores[bestApplicantIndex] ||
                   (creditScores[i] == creditScores[bestApplicantIndex] &&
                    monthlyIncomes[i] > monthlyIncomes[bestApplicantIndex])) {

                    bestApplicantIndex = i;
                }
            }
        }

        System.out.println("\n----- Summary -----");
        System.out.println("Total Approvals: " + approvals);
        System.out.println("Total Rejections: " + rejections);

        if (bestApplicantIndex != -1) {
            System.out.println("Best Approval Profile Applicant Index: " + bestApplicantIndex);
        } else {
            System.out.println("No eligible applicants.");
        }

        scanner.close();
    }
}
