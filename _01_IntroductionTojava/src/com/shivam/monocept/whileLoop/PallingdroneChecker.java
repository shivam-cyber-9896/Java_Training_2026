package com.shivam.monocept.whileLoop;

import java.util.Scanner;

public class PallingdroneChecker {

	public static void main(String[] args) {
	
		        Scanner input = new Scanner(System.in);

		        System.out.println("Enter a number: ");
		        int number = input.nextInt();
		        if(number<10) {
					System.out.print("You have enter at least two dgit no");
					return;
					}
		        int original = number;
		        int reversed = 0;

		        while (number > 0) {
		            int remainder = number % 10;
		            reversed = reversed * 10 + remainder;
		            number = number / 10;
		        }

		        if (original == reversed) {
		            System.out.println("It is a Palindrome number.");
		        } else {
		            System.out.println("It is NOT a Palindrome number.");
		        }

		        input.close();
		    }
		}

