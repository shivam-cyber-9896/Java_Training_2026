package com.shivam.monocept.arrays;

import java.util.Scanner;

public class SumOfElementOfArrays {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = scanner.nextInt();

        while(n<=0) {
        	System.out.println("Enter a Vaild Integer value above 0");
        	System.out.print("Enter size again: ");
        	n=scanner.nextInt();
        	
        }
        
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0;

        for (int i=0; i<arr.length;i++) {
            sum += arr[i];
        }

        System.out.println("Sum = " + sum);
    }

}
