package com.shivam.monocept.arrays;

import java.util.Scanner;

public class SecondMaxElementOfArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        int max=arr[0];
        int SecondMax=0;
        for(int i=0;i<arr.length;i++) {
        	if(max<arr[i]) {
        		SecondMax=max;
        		max=arr[i];
        	}
        	else if (arr[i] > SecondMax && arr[i] != max) {
                SecondMax = arr[i];
            }
        }
        if(SecondMax==0) {
        	System.out.println("You enter list of a no of asame element");
        	return;
        	
        }
        System.out.println("Second largest element is = "+SecondMax);
	}

}
