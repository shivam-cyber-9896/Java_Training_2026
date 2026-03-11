package com.shivam.monocept.task;

import java.util.Scanner;

public class InsuranceRiskPortfolioAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];
        int[] riskScores = new int[n];

        System.out.println("Enter ages of customers:");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        System.out.println("Enter risk scores of customers (0-100):");
        for (int i = 0; i < n; i++) {
            riskScores[i] = scanner.nextInt();
        }

        int highRiskYouth = 0;
        int seniorRisk = 0;
        int veryHighRisk = 0;
        int normalRisk = 0;

        int totalRiskScore = 0;
        int highestRiskIndex = 0;

        for (int i = 0; i < n; i++) {

            totalRiskScore += riskScores[i];

            if (riskScores[i] > riskScores[highestRiskIndex]) {
                highestRiskIndex = i;
            }

            if (riskScores[i] >= 85) {
                System.out.println("Customer " + i + ": Very High Risk");
                veryHighRisk++;

            } else if (ages[i] < 25 && riskScores[i] > 70) {
                System.out.println("Customer " + i + ": High Risk Youth");
                highRiskYouth++;

            } else if (ages[i] >= 60) {
                System.out.println("Customer " + i + ": Senior Risk");
                seniorRisk++;

            } else {
                System.out.println("Customer " + i + ": Normal Risk");
                normalRisk++;
            }
        }

        double averageRisk = (double) totalRiskScore / n;

        System.out.println("\n----- Summary -----");
        System.out.println("Very High Risk: " + veryHighRisk);
        System.out.println("High Risk Youth: " + highRiskYouth);
        System.out.println("Senior Risk: " + seniorRisk);
        System.out.println("Normal Risk: " + normalRisk);

        System.out.println("Average Risk Score: " + averageRisk);
        System.out.println("Highest Risk Customer Index: " + highestRiskIndex);

        scanner.close();
    }
}
