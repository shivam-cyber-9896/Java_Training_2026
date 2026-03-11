package com.shivam.monocept.whileLoop;

import java.util.Scanner;

public class PrimeNumberChecker {
	

	    public static void main(String[] args) {

	        Scanner input = new Scanner(System.in);

	        System.out.println("Enter a number:");
	        int number = input.nextInt();

	        boolean isPrime = true;

	        if (number <= 1) {
	            isPrime = false;
	        } else {
	        	int i = 2;
	            while(i < number*number) {
	                if (number % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	                i++;
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


