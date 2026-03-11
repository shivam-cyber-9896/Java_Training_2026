package com.shivam.moncept.first.puc;

import java.util.Scanner;

public class TypeCastingImplicitDemo {
	public static void main(String[] args) {
		

		  

		        Scanner scanner = new Scanner(System.in);

		    
		        System.out.print("Enter a byte value: ");
		        byte b = scanner.nextByte();

		   
		        int intValue = b;

		    
		        double doubleValue = intValue;

		        System.out.println("Original byte value: " + b);
		        System.out.println("After converting to int: " + intValue);
		        System.out.println("After converting to double: " + doubleValue);

		        
		    }
		

	}


