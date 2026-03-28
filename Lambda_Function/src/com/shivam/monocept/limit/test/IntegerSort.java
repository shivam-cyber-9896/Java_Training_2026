package com.shivam.monocept.limit.test;

import java.util.Comparator;
import java.util.List;

public class IntegerSort {

	public static void main(String[] args) {
    List.of(1,2,3,4,5,6,7,8,9,10,11,12,14,15,13,16,76,12)
    .stream()
    .sorted(Comparator.reverseOrder())
    .limit(5)
    .forEach(System.out::println);

	}

}
