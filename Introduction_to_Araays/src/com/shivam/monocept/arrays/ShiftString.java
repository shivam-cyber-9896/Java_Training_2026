package com.shivam.monocept.arrays;

import java.util.Scanner;

public class ShiftString {


	    public static String shiftString(String str, int shift) {
	        StringBuilder result = new StringBuilder();

	        for (char ch : str.toCharArray()) {

	            if (Character.isLowerCase(ch)) {
	                char newChar = (char) ((ch - 'a' + shift + 26) % 26 + 'a');
	                result.append(newChar);

	            } else if (Character.isUpperCase(ch)) {
	                char newChar = (char) ((ch - 'A' + shift + 26) % 26 + 'A');
	                result.append(newChar);

	            } else {
	                result.append(ch); // special characters unchanged
	            }
	        }

	        return result.toString();
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the string: ");
	        String input = sc.nextLine(); 

	        System.out.print("Enter shift value: ");
	        int shift = sc.nextInt();

	        String result = shiftString(input, shift);

	        System.out.println("Shifted String: " + result);

	        sc.close();
	    }
	}



