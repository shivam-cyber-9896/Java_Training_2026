package com.shivam.monocept.arrayofobj.model1;


 public abstract class Course {

 private static long courseId;
 protected String courseName;
 protected final double baseFee=10000;

 protected static int totalCourses = 0;
 private static long counter = 13273;

 public Course(String courseName) {
     Course.courseId = ++counter;
     this.courseName = courseName;
     
     totalCourses++;
 }

 
 public double calculateFee() {
     return baseFee;
 }

 public String getCourseName() {
	return courseName;
}

 public double calculateFee(double extraCharges) {
     return baseFee + extraCharges;
 }

 
 public abstract double getFinalFee();

 public static int getTotalCourses() {
     return totalCourses;
 }
}

