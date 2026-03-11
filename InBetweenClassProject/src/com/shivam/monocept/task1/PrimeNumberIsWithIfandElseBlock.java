package com.shivam.monocept.task1;

import java.util.Scanner;

public class PrimeNumberIsWithIfandElseBlock {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number:");
		int number = input.nextInt();

		boolean isPrime = true;

		if (number <= 1) {
			isPrime = false;
		} else {

			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
		}

		if (isPrime) {
			System.out.println("It is a Prime number.");
		} else {
			System.out.println("It is NOT a Prime number.");
		}

		input.close();
	}
}
