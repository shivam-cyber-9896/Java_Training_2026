package com.shivam.monocept.toarray.test;

import java.util.Arrays;
import java.util.List;

public class StringConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] arr= {
		"Hlo","hye","Bye","Snitch","Are","You"
};
List<String> list=Arrays.stream(arr).map(m->m.toUpperCase()).toList();
System.out.println(list);
	}

}
