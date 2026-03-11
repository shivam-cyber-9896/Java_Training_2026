package com.shivam.monocept.arrays;

import java.util.Scanner;

public class MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int max = 0;

		for (int num : nums) {
			if (num == 1) {
				count++;
				max = Math.max(max, count);
			} else {
				count = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter size: ");
		int n = scanner.nextInt();

		while (n <= 0) {
			System.out.println("Enter a Vaild Integer value above 0");
			System.out.print("Enter size again: ");
			n = scanner.nextInt();

		}

		int[] arr = new int[n];

		System.out.println("Enter elements of binary:");
		for (int i = 0; i < n; i++) {

			arr[i] = scanner.nextInt();
			if (arr[i] != 0 || arr[i] != 1) {
				System.out.print("PLease enter a binary value  ");
				System.out.print("Enter new value ");
				System.out.println();
				arr[i] = scanner.nextInt();

			}
		}

		int result = findMaxConsecutiveOnes(arr);

		System.out.println("Maximum consecutive 1s: " + result);
	}
}
