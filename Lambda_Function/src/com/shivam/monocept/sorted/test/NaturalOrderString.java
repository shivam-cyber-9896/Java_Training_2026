package com.shivam.monocept.sorted.test;

import java.util.List;

public class NaturalOrderString {

	public static void main(String[] args) {
		List<String> names = List.of("Riya", "Arun", "Neha", "Karan");

		names.stream()
		     .sorted()
		     .forEach(System.out::println);
		names.stream()
	     .sorted((a, b) -> b.compareTo(a))
	     .forEach(System.out::println);

	}

}
