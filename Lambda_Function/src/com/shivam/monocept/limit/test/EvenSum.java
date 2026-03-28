package com.shivam.monocept.limit.test;

import java.util.List;

public class EvenSum {

	public static void main(String[] args) {
		int sum=List.of(1,2,3,4,5,6,7,8,9,10,11,13,12,16).stream()
				.filter(m->m%2==0)
				.limit(5)
				.reduce(0, (a, b) -> a + b);

		System.out.println(sum);

	}

}
