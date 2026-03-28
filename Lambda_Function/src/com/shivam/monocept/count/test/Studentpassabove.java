package com.shivam.monocept.count.test;

import java.util.List;

public class Studentpassabove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list =List.of(
	            new Student("Arun", 100),
	            new Student("Riya", 45),
	            new Student("Karan", 15),
	            new Student("Neha", 7),
	            new Student("Rahul", 30)
	        );
	Long counter=	list.stream()
		.filter(s->s.Marks>=35)
		.count();
	System.out.println("Passed Student "+counter);
	}

}
