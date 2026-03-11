package com.shivam.monocept.arrays;

import java.util.Scanner;

public class PeakElementOfArrays {

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
        System.out.println("Peak Element: " + findPeak(arr));
    }

	    public static int findPeak(int[] arr) {
	        int n = arr.length;

	        if (n == 1)
	            return arr[0];

	        
	        if (arr[0] >= arr[1])
	            return arr[0];

	        
	        for (int i = 1; i < n - 1; i++) {
	            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
	                return arr[i];
	            }
	        }

	        
	        if (arr[n - 1] >= arr[n - 2])
	            return arr[n - 1];

	        return -1;
	    

	}


}
