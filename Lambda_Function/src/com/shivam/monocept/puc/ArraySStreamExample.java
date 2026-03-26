package com.shivam.monocept.puc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySStreamExample {

	public static void main(String[] args) {
		int[] number= {1,2,4,4,5,6,7};
		IntStream arraysStream=Arrays.stream(number);
		arraysStream.forEach(System.out::println);
	}

}
