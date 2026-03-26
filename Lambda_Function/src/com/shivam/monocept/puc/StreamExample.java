package com.shivam.monocept.puc;

import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> number=List.of(1,2,3,4,5,6,7);
		Stream<Integer> numberStream=number.stream();
		numberStream.forEach(System.out::println);

	}

}
