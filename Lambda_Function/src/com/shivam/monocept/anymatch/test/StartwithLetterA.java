package com.shivam.monocept.anymatch.test;

import java.util.List;

public class StartwithLetterA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = List.of("Shivam", "Aman", "Rohit");

		boolean startsWithA = names.stream()
		        .anyMatch(name -> name.startsWith("A"));

		System.out.println(startsWithA);
	}

}
