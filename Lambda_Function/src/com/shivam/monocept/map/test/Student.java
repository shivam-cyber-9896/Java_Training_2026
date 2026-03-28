package com.shivam.monocept.map.test;

public class Student {
String Name;
Integer Marks;
public Student(String name, Integer marks) {
	Name = name;
	Marks = marks;
}
@Override
public String toString() {
	return "Student [Name=" + Name + ", Marks=" + Marks + "]";
}
}
