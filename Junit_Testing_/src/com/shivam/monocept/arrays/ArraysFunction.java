package com.shivam.monocept.arrays;

public class ArraysFunction {
	public int[] reverseArray(int[] arr) {
        if (arr == null) return null;

        int[] result = new int[arr.length];
        int j = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            result[j++] = arr[i];
        }

        return result;
    }
}
