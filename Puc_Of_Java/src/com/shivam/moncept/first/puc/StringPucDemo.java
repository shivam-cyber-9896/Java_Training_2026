package com.shivam.moncept.first.puc;

import java.util.Scanner;

public class StringPucDemo {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		System.out.println("Length of name: " + name.length());

		System.out.println("Uppercase: " + name.toUpperCase());

		System.out.println("Lowercase: " + name.toLowerCase());

		System.out.println("First character: " + name.charAt(0));

		System.out.println("Contains letter 'a': " + name.contains("a"));

		System.out.println("Replace 'a' with '@': " + name.replace("a", "@"));

		System.out.println("After trim: " + name.trim());

		System.out.print("Enter another name to compare: ");
		String name2 = scanner.nextLine();

		System.out.println("Are both names equal? " + name.equals(name2));

	}

}
