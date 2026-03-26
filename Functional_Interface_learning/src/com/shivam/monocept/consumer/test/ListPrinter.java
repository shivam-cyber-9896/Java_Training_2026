package com.shivam.monocept.consumer.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListPrinter {
	public static void main(String[] args) {
		List <String> names=Arrays.asList("java","spring ","angular");
		Consumer<String>  Print=x -> System.out.println(x); 
		for(String s:names)
			Print.accept(s);
	}
}
