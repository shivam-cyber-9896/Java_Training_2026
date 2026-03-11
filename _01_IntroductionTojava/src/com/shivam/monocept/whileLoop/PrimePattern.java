package com.shivam.monocept.whileLoop;

import java.util.Scanner;

public class PrimePattern {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of rows: ");
		int rows = sc.nextInt();

		int number = 2;
		int i = 1;

		while (i <= rows) {

			int count = 0;

			while (count < i) {

				if (isPrime(number)) {
					System.out.print(number + " ");
					count++;
				}

				number++;

			}

			System.out.println();
			i++;
		}

		sc.close();
	}

	public static boolean isPrime(int num) {

		if (num <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}

		return true;
	}
}
