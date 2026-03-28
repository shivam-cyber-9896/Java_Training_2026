package com.shivam.monocept.skip.test;

import java.util.Comparator;
import java.util.List;

public class TopSalerySort {

	public static void main(String[] args) {
		List.of(1100,1200,1300,1400,15000,1600,11).stream()
		.sorted(Comparator.reverseOrder())
		.skip(2)
		.forEach(System.out::println);

	}

}
