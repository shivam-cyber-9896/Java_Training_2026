package com.shivam.monocept.task;
import java.util.Scanner;

public class FraudTransactionDetector {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = scanner.nextInt();

        double[] transactions = new double[n];

        System.out.println("Enter transaction amounts:");

        for (int i = 0; i < n; i++) {
            transactions[i] = scanner.nextDouble();
        }

        double total = 0;
        boolean potentialFraud = false;

        System.out.println("\n--- Transaction Analysis ---");

        for (int i = 0; i < n; i++) {

            total += transactions[i];

            if (transactions[i] > 50000) {
                System.out.println("Transaction " + i + " is Suspicious");
            }

           
            if (i >= 1) {
                if (transactions[i] > 50000 &&
                    transactions[i - 1] > 50000) {

                    potentialFraud = true;
                }
            }
        }

        double average = total / n;

        System.out.println("\n--- Summary ---");
        System.out.println("Average Transaction Value: " + average);

        if (potentialFraud) {
            System.out.println("Potential Fraud Detected!");
        } else {
            System.out.println("No Fraud Pattern Detected.");
        }

        if (average > 40000) {
            System.out.println("High Value Account");
        }

        scanner.close();
    }
}
