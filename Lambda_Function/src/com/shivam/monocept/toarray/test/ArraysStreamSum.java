package com.shivam.monocept.toarray.test;

import java.util.Arrays;

public class ArraysStreamSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(arr).sum();

        System.out.println("Sum = " + sum);
	}

}
