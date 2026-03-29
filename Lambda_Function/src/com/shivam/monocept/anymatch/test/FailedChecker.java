package com.shivam.monocept.anymatch.test;

import java.util.List;



public class FailedChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = List.of(
	            new Student("Arun", 100),
	            new Student("Riya", 65),
	            new Student("Karan", 45),
	            new Student("Neha", 75),
	            new Student("Rahul", 30)
	        );
		boolean fail=list.stream()
				.anyMatch(s->s.Marks<40);
		System.out.println(fail);
	}

}
