package com.shivam.monocept.forLoop;

import java.util.Scanner;

public class PrintingPattern {
	
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        System.out.print("Enter number of rows: ");
	        int n = input.nextInt();
            
	        for (int i = 1; i <= n; i++) {      
	            for (int j = 1; j <= i; j++) {   
	                System.out.print("*");
	            }
	            System.out.println();
	        }

	        input.close();
	    }
	}



