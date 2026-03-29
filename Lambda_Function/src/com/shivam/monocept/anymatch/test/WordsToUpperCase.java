package com.shivam.monocept.anymatch.test;

import java.util.List;

public class WordsToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = List.of("java", "PYTHON", "code");

		boolean hasUppercase = words.stream()
		        .anyMatch(word -> word.equals(word.toUpperCase()));

		System.out.println(hasUppercase);
	}

}
