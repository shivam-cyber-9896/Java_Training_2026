package com.shivam.monocept.limit.test;

import java.util.Comparator;
import java.util.List;

public class WordListPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      List.of("Anu","Akash","Abhishek","Rahul","Rohit","Ravi","Permod")
      .stream().sorted(Comparator.comparingInt(s->((String) s).length()).reversed())
      .limit(3).forEach(System.out::println);
	}

}
