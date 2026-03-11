package com.shivam.monocept.arrayofobj.model1;

 public class OnlineCourse extends Course {

	 private double platformFee;

	 public OnlineCourse( String courseName, double platformFee) {
	     super(courseName); // Constructor Chaining
	     this.platformFee = platformFee;
	 }

	 @Override
	 public double getFinalFee() {
	     return calculateFee(platformFee); // Polymorphism
	 }
	}
