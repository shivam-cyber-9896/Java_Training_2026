package com.shivam.monocept.filter.test;

import java.util.List;
import java.util.stream.Stream;

public class EvenInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
		Stream<Integer> isEven=list.stream();
		isEven.filter(X -> X%2==0)
		      .forEach(System.out::println);
	}

}
