package com.shivam.monocept.skip.test;

import java.util.List;

public class WordSkipper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    List.of("aman","Abhishek","lalu","Anu","a","b","c","aaaa","bbc","llll")
    .stream().filter(m ->m.length()>3).skip(3).forEach(System.out::println);
	}

}
