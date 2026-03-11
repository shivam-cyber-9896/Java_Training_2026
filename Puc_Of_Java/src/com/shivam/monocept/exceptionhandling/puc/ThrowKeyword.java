package com.shivam.monocept.exceptionhandling.puc;

import java.util.Scanner;

public class ThrowKeyword {

    static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote");
        }
        System.out.println("Eligible");
        
    }

    public static void main(String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
		System.out.println("Enter your age to check you are able to vote or not");
		   int x=scanner.nextInt();
		   checkAge(x);
	   }
       catch(Exception e) {
    	   System.out.println("try with resoure " +e);
       }
    }
}