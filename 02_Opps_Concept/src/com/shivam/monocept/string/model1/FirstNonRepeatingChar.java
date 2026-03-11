package com.shivam.monocept.string.model1;

import java.util.Scanner;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter a Char");
		String sentance = scanner.next();

		for (int i = 0; i < sentance.length(); i++) {

			boolean unique = true;

			for (int j = 0; j < sentance.length(); j++) {

				if (i != j && sentance.charAt(i) == sentance.charAt(j)) {
					unique = false;
					break;
				}
			}

			if (unique) {
				System.out.println("First non repeating character: " + sentance.charAt(i));
				break;
			}
		}
	}
}