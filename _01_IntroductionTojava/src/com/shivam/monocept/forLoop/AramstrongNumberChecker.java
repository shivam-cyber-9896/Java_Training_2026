package com.shivam.monocept.forLoop;

import java.util.Scanner;

public class AramstrongNumberChecker {

    public static void main(String[] args) {

    	Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        String number = input.nextLine();   
         if(number.length()== 1) {
        	 return;
         }
        int length = number.length();       
        int sum = 0;

        
        for (int i = 0; i < length; i++) {

            int digit = number.charAt(i) - '0';  // Convert char to int
            sum += (int) Math.pow(digit, length);
        }

      
        int original = Integer.parseInt(number);

        if (sum == original) {
            System.out.println("It is an Armstrong number.");
        } else {
            System.out.println("It is NOT an Armstrong number.");
        }

        input.close();
    }
}