package com.shivam.monocept.sorted.test;

import java.util.List;

public class ListSortedIncresingOrder {

	public static void main(String[] args) {
	List.of(1,4,5,55,2,2,1,34,455,567,233,435,255,44,4,646,444,4,34,67,553,455,5676,67,77,88,22,33,34)
	.stream().sorted().forEach(System.out::println);
	}

}
