package com.shivam.monocept.function.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class StudentGradeGenrater {

	public static void main(String[] args) {
		 List<Integer> marksList = Arrays.asList(85, 60, 45, 75, 30);
		Function<Integer,String> gradeGenrater=m ->{
			 if (m >= 75) {
	                return "A";
	            } 
			 if (m >= 50) {
	                return "B";
	            } 
	                return "Fail";
	            
		};
		for(int i:marksList) {
		System.out.println(gradeGenrater.apply(i));
		}
	}

}
