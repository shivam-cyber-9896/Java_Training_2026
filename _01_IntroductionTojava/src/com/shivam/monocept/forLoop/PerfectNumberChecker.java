package com.shivam.monocept.forLoop;

import java.util.Scanner;

public class PerfectNumberChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);

	        System.out.println("Enter a number:");
	        int number = input.nextInt();
	        if(number<0) {
            	System.out.println("PLese enter a number is above 0");
            	return;}
	        int sum = 0;

	        
	        for (int i = 1; i < number; i++) {
	            if (number % i == 0) {
	                sum += i;
	            }
	        }

	        
	        if (sum == number) {
	            System.out.println("It is a Perfect number.");
	        } else {
	            System.out.println("It is NOT a Perfect number.");
	        }

	        input.close();
	    }
	}

