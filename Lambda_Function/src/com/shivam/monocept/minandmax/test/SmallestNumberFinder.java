package com.shivam.monocept.minandmax.test;

import java.util.Comparator;
import java.util.List;

public class SmallestNumberFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int min=   List.of(1,2,3,4,5,6,7,8,9,-1,-2,-99,-9828,11,12,222,3,33,33,-10000,1)
        .stream().min(Comparator.naturalOrder())
        .get();
     System.out.println("Minum value"+min);
	}

}
