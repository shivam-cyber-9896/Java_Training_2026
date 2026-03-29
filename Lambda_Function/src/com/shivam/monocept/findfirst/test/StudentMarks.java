package com.shivam.monocept.findfirst.test;

import java.util.List;
import java.util.Optional;


public class StudentMarks {

	public static void main(String[] args) {
		
		List<Student> list = List.of(
	            new Student("Arun", 10),
	            new Student("Riya", 5),
	            new Student("Karan", 45),
	            new Student("Neha", 75),
	            new Student("Rahul", 30)
	        );
		Optional<Student>student= list.stream()
				.filter(s->s.Marks>=45).findFirst();
		student.ifPresent(System.out::println);
	}

}
