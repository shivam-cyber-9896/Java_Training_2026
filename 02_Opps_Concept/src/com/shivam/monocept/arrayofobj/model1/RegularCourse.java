package com.shivam.monocept.arrayofobj.model1;
public class RegularCourse extends Course {

	 private double labFee;

	 public RegularCourse( String courseName,double labFee) {
	     super(courseName); 
	     this.labFee = labFee;
	 }

	 @Override
	 public double getFinalFee() {
	     return calculateFee(labFee); 
	}
}