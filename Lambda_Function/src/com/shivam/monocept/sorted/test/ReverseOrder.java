package com.shivam.monocept.sorted.test;

import java.util.Comparator;
import java.util.List;

public class ReverseOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     List.of("anu","zny","cow","bow","row","coloum","cat")
     .stream()
     .sorted(Comparator.reverseOrder())
     .forEach(System.out::println);
	}

}
