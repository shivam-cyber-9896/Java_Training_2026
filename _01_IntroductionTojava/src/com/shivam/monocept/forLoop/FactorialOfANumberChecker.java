package com.shivam.monocept.forLoop;

import java.util.Scanner;

public class FactorialOfANumberChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner input=new Scanner(System.in);
   System.out.println("Enter a NO to find a factoral");
   int number=input.nextInt();
   if(number<1) {
	   System.out.println("Enter a no of digit aabove 0");
	   return;
   }
   int factorial=1;
   for(int i=1;i<=number;i++) {
	   factorial=i*factorial;
	}
   System.out.println("Factorial number is ="+factorial);
}
}
