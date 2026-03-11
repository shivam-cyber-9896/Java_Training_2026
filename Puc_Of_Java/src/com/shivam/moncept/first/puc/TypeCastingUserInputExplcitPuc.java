package com.shivam.moncept.first.puc;

import java.util.Scanner;

public class TypeCastingUserInputExplcitPuc {
	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	 System.out.print("Enter a decimal number: ");
     double num = scanner.nextDouble();   // user enters 12.75

     int converted = (int) num;      // explicit casting

     System.out.println("Original value: " + num);
     System.out.println("After casting to int: " + converted);
     
     System.out.print("Enter an integer value above 126: ");
     int num1 = scanner.nextInt();   // user enters 130

     byte b = (byte) num1;      // explicit casting

     System.out.println("Original int value: " + num1);
     System.out.println("After casting to byte: " + b);

	

}
}
