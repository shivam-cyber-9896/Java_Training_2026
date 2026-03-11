package com.shivam.monocept.whileLoop;

import java.util.Scanner;

public class SumOfDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int Sum = 0;

		System.out.println("enter your Number and See  sum of digit ");
		int digit= input.nextInt();
		if(digit<10) {
			System.out.print("You have enter at least two dgit no");
			return;
			}
		int i=digit;
		while(i>0) {
		 int k=i%10;
		 Sum=Sum+k;
		 i=i/10;
		}

		System.out.println("Sum of Digit  is: " +Sum);

			}
	}

}
