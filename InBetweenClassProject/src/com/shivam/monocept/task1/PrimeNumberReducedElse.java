package com.shivam.monocept.task1;

import java.util.Scanner;

public class PrimeNumberReducedElse {
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();
               boolean isPrime = true;
               if(number<=1) {
            	   System.out.println("enter number is not prime");
            	   return;
               }
               if(number==2) {
            	   System.out.println("You enter a prime no");
            	   return;
               }
            for(int i=3;i<number;i++) {
                 if(number%i==0)	{
                	 isPrime =false;
                      System.out.println("is Not a Prime no");
                     break;
                 }
            }
            if(isPrime) {
            	System.out.println("number enter is a prime "+number);
            	return;
            }
               
}
}
