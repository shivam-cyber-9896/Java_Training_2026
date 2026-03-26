package com.shivam.monocept.puc;

import java.util.stream.Stream;

public class StreamOfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Stream<String>stream=Stream.of("Java","Py","React","Node");
       stream.forEach(System.out::println);
	}

}
