package com.shivam.monocept.arrays;

import java.util.Scanner;

public class NumberRepresenterCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

    
        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
      while(n<=0) {
    	  System.out.println("plese enter vaild integer number above 0");
    	  System.out.print("Enter size of array: ");
           n = scanner.nextInt();
      }

        int[] arr = new int[n];

        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

      
        System.out.print("Enter element to count: ");
        int target = scanner.nextInt();

        int count = 0;

       
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                count++;
            }
        }

        System.out.println(target + " appears " + count + " times.");
    }
}



