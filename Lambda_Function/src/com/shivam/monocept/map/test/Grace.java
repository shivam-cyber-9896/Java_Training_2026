package com.shivam.monocept.map.test;

import java.util.List;



public class Grace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list =List.of(
	            new Student("Arun", 100),
	            new Student("Riya", 35),
	            new Student("Karan", 35),
	            new Student("Neha", 75),
	            new Student("Rahul", 30)
	        );
list.stream().filter(s->s.Marks==35)

.map(s -> s.Marks == 35 ? s.Marks + 5 : s.Marks)
.forEach(System.out::println);
	}

}
