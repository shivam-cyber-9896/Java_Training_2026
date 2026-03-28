package com.shivam.monocept.limit.test;

import java.util.List;

public class LimitPrint {

	public static void main(String[] args) {
		 List.of("Lalit","lalu","papu","Shivam","pares","amit").stream().limit(3)
	      .forEach(System.out::println);
	}

}
