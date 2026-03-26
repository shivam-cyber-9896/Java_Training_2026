package com.shivam.monocept.predicate.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PassingMarksChecker {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
	            new Student("Aman", 35),
	            new Student("Riya", 75),
	            new Student("Karan", 40),
	            new Student("Neha", 20),
	            new Student("Rahul", 55)
	        );
		
		Predicate<Student> isPass=s->s.marks>40;
		for(Student s:students)
		{
			System.out.println("Student detail");
			System.out.println("name :"+s.name);
			System.out.println(" Marks :"+s.marks);
			System.out.println("Result  :"+isPass.test(s));
		}
	}

}
