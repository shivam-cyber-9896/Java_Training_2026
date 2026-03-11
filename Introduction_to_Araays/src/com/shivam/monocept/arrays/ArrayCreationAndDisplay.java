package com.shivam.monocept.arrays;

import java.util.Scanner;

public class ArrayCreationAndDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = scanner.nextInt();

        while(n<=0) {
        	System.out.println("Enter a Vaild Integer value above 0");
        	System.out.print("Enter size again: ");
        	n=scanner.nextInt();
        	System.out.println();
        }
        
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

	}

}
}
