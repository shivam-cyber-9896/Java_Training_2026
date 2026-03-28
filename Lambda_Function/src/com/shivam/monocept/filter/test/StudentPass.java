package com.shivam.monocept.filter.test;

import java.util.List;
import java.util.stream.Stream;

public class StudentPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = List.of(
	            new Student("Arun", 100),
	            new Student("Riya", 65),
	            new Student("Karan", 45),
	            new Student("Neha", 75),
	            new Student("Rahul", 30)
	        );
Stream<Student>  print=list.stream();
print.filter(S -> S.Marks >=40)
.forEach(System.out::println);
	}

}
