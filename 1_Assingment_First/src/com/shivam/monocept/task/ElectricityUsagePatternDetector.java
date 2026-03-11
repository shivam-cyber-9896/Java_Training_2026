package com.shivam.monocept.task;

import java.util.Scanner;

public class ElectricityUsagePatternDetector {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] usage = new int[30];

		System.out.println("Enter electricity usage for 30 days:");

		for (int i = 0; i < 30; i++) {
			usage[i] = scanner.nextInt();
		}

		int highConsumptionCount = 0;
		int totalUsage = 0;
		boolean overloadWarning = false;

		for (int i = 0; i < 30; i++) {

			totalUsage += usage[i];

			System.out.print("Day " + (i + 1) + ": ");

			if (usage[i] > 500) {
				System.out.println("High Consumption");
				highConsumptionCount++;
			} else if (usage[i] < 100) {
				System.out.println("Low Usage Alert");
			} else {
				System.out.println("Normal Usage");
			}

			// Check 3 consecutive high consumption days
			if (i >= 2) {
				if (usage[i] > 500 && usage[i - 1] > 500 && usage[i - 2] > 500) {

					overloadWarning = true;
				}
			}
		}

		double average = (double) totalUsage / 30;

		System.out.println("\n----- Monthly Report -----");
		System.out.println("Monthly Average Usage: " + average);
		System.out.println("High Consumption Days: " + highConsumptionCount);

		if (overloadWarning) {
			System.out.println("Overload Warning Detected!");
		} else {
			System.out.println("No Overload Warning.");
		}

		if (average > 400) {
			System.out.println("Heavy Month");
		}

		scanner.close();
	}
}
