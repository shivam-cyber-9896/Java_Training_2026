package com.shivam.monocept.minandmax.test;

import java.util.Comparator;
import java.util.List;


public class StudentFilterWithMarks {

	public static void main(String[] args) {
		
		List<Student> list =List.of(
	            new Student("Arun", 100),
	            new Student("Riya", 35),
	            new Student("Karan", 35),
	            new Student("Neha", 75),
	            new Student("Rahul", 30)
	        );
	  list.stream()
			  .max(Comparator.comparing(s ->s.Marks))
			  .ifPresent(System.out::println);
	
	}

}
