package com.shivam.monocept.forLoop;

import java.util.Scanner;

public class ReverseDigit {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		 int reversed = 0;
		 
		System.out.println("enter your Digit to be revsed ");
		int digit= input.nextInt();
		if(digit<10) {
			System.out.print("You have enter at least two dgit no");
			return;
			}
      for(int i=digit;i>0;i=i/10) {
    	  
    	  int remainder = i % 10;     // get last digit
          reversed = reversed * 10 + remainder;  // build reversed number
      }

      System.out.println("Reversed number is: " + reversed);

}
	
}
