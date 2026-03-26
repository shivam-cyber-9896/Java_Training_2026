package com.shivam.monocept.predicate.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NonEmptyStringChecker {

	public static void main(String[] args) {
		List<String> names=Arrays.asList("   ","java","Spring");
		Predicate<String> Empty=n->n !=null&&n.trim().isEmpty(); 
		for(String name:names)
		{System.out.println(name+"  "+Empty.test(name));
			
		}
	}

}
