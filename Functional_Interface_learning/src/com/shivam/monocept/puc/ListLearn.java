package com.shivam.monocept.puc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListLearn {

	public static void main(String[] args) {
		List <String> names=Arrays.asList("java","spring ","angular");
		Consumer<List>  Print=x -> System.out.println(x); 
		Print.accept(names);
	}

}
