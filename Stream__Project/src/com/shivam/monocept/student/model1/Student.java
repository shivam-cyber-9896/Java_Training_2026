package com.shivam.monocept.student.model1;

public class Student {
 private int rollNo;
 private  String name;
 private String standard;
 private int marks;
 private  String section;
 public Student(int rollNo, String name, String standard, int marks, String section) {
	this.rollNo = rollNo;
	this.name = name;
	this.standard = standard;
	this.marks = marks;
	this.section = section;
 }
 public int getRollNo() {
	return rollNo;
 }
 
 public String getName() {
	return name;
 }
 
 public String getStandard() {
	return standard;
 }
 
 public int getMarks() {
	return marks;
 }
 
 public String getSection() {
	return section;
 }
 @Override
 public String toString() {
	return "Student [rollNo=" + rollNo + ", name=" + name + ", standard=" + standard + ", marks=" + marks + ", section="
			+ section + "]";
 }
 
 
}
