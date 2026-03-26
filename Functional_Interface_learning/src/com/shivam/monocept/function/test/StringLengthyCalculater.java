package com.shivam.monocept.function.test;

import java.util.Scanner;
import java.util.function.Function;

public class StringLengthyCalculater {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter a value");
		String Line= scanner.next();
		Function<String,Integer> length=str -> str.length();
		System.out.println(Line);
		System.out.println("Length is :"+length.apply(Line));
	}

}
