package com.shivam.monocept.exceptionhandling.puc;

import java.io.FileReader;

public class firstPuc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        try {
		            int a = 10;
		            int b = 0;
		            int result = a / b;  
		            System.out.println(result);
		        } 
		        catch (Exception e) {
		            System.out.println("You cannot divide by zero" +e);
		        }

		        System.out.println("Program Ended Successfully");
		    
	 try {
         FileReader file = new FileReader("abc.txt");
         System.out.println("File opened");
     } 
     catch (Exception e) {
         System.out.println("File not found" +e);
     }
		
	}
}


