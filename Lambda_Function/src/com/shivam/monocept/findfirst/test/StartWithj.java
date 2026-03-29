package com.shivam.monocept.findfirst.test;

import java.util.List;
import java.util.Optional;

public class StartWithj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = List.of("Apple", "Java", "Python", "Javascript", "C++");

        Optional<String> result = words.stream()
                .filter(word -> word.startsWith("J"))
                .findFirst();

        result.ifPresent(System.out::println);
	}

}
