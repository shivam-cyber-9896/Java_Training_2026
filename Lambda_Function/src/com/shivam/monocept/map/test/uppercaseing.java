package com.shivam.monocept.map.test;

import java.util.List;

public class uppercaseing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>list=List.of("hello","hi","Hye","Bye","dvdg","dog","cat");
		list.stream()
		.map(m->m.toUpperCase())
		.forEach(System.out::println);

	}

}
