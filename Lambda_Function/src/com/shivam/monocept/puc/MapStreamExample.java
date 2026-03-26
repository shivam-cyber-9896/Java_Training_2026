package com.shivam.monocept.puc;

import java.util.Map;
import java.util.stream.Stream;

public class MapStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Map<String ,Integer> details=Map.of("java",100,"Python",123);
Stream<String> Name=details.keySet().stream();
Name.forEachOrdered(System.out::println);
Stream <Integer> Value=details.values().stream();
Value.forEach(System.out::println);

Stream<Map.Entry<String, Integer>> map=details.entrySet().stream();
map.forEach(System.out::println);



	}

}
