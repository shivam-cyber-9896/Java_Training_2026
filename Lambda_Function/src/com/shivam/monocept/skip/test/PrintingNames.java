package com.shivam.monocept.skip.test;

import java.util.List;

public class PrintingNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      List.of("Lalit","lalu","papu","Shivam","pares","amit").stream().skip(3)
      .forEach(System.out::println);
	}

}
