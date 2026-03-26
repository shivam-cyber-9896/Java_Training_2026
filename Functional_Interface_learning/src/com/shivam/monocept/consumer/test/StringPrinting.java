package com.shivam.monocept.consumer.test;

import java.util.Scanner;
import java.util.function.Consumer;

public class StringPrinting {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter a value");
		String Line= scanner.next();
		Consumer<String> toupperCase= str -> System.out.println(str.toUpperCase());
	    toupperCase.accept(Line);
	
	}
}
