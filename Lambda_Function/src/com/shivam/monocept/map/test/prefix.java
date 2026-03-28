package com.shivam.monocept.map.test;

import java.util.List;

public class prefix {
	public static void main(String[] args) {

        List<String> names = List.of("Shivam", "Riya", "Aman","Abhishek");

        names.stream()
             .map(name -> "Mr./Ms. " + name)
             .forEach(System.out::println);
    }
}
