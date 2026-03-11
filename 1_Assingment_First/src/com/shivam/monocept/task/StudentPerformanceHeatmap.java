package com.shivam.monocept.task;

import java.util.Scanner;

public class StudentPerformanceHeatmap {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[][] marks = new int[n][5];

        System.out.println("Enter marks for each student (5 subjects):");

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                marks[i][j] = scanner.nextInt();
                if(marks[i][j]>100) {
                	System.out.println("Enter a marks betwwen  0 to 100 pLese enter a new marks");
                	marks[i][j]=scanner.nextInt();
                }
            }
        }

        int distinctionCount = 0;
        int bestSubjectIndex = 0;
        double highestSubjectAverage = 0;

        // To store total marks per subject
        int[] subjectTotals = new int[5];

        for (int i = 0; i < n; i++) {

            int total = 0;
            boolean isFail = false;

            for (int j = 0; j < 5; j++) {

                total += marks[i][j];

                subjectTotals[j] += marks[i][j];

                if (marks[i][j] < 35) {
                    isFail = true;
                }
            }

            double average = (double) total / 5;

            System.out.print("Student " + (i + 1) + ": ");

            if (isFail) {
                System.out.println("Fail");
            } else if (average >= 85) {
                System.out.println("Distinction");
                distinctionCount++;
            } else if (average >= 60) {
                System.out.println("First Class");
            } else if (average >= 50) {
                System.out.println("Second Class");
            } else {
                System.out.println("Pass");
            }
        }

        // Find subject with highest average
        for (int j = 0; j < 5; j++) {

            double subjectAverage = (double) subjectTotals[j] / n;

            if (j == 0 || subjectAverage > highestSubjectAverage) {
                highestSubjectAverage = subjectAverage;
                bestSubjectIndex = j;
            }
        }

        System.out.println("\n----- Summary -----");
        System.out.println("Number of Distinctions: " + distinctionCount);
        System.out.println("Subject with Highest Overall Average: Subject " 
                            + (bestSubjectIndex + 1));
        System.out.println("Highest Subject Average: " + highestSubjectAverage);

        scanner.close();
    }
}
