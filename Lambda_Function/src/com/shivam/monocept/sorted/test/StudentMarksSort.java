package com.shivam.monocept.sorted.test;

import java.util.Comparator;
import java.util.List;



public class StudentMarksSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list =List.of(
	            new Student("Arun", 100),
	            new Student("Riya", 35),
	            new Student("Karan", 35),
	            new Student("Neha", 75),
	            new Student("Rahul", 30)
	        );
		list.stream()
		.sorted(Comparator.comparingInt(s ->s.Marks))
		.forEach(System.out::println);
	}

}
