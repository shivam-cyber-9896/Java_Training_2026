package com.shivam.monocept.whileLoop;

import java.util.Scanner;

public class PrintingPattern {
	
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        System.out.print("Enter number of rows: ");
	        int n = input.nextInt();
	        int i = 1;
	        
	        while ( i <= n) {  
	        	int j=1;
	            while ( j <= i) {   
	                System.out.print("*");
	                j++;
	            }
	            i++;
	            System.out.println();
	            
	        }

	        input.close();
	    }
	}



