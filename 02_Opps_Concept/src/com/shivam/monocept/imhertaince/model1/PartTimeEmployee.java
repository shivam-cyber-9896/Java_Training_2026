package com.shivam.monocept.imhertaince.model1;

 public class PartTimeEmployee extends Employee {

 private int hoursWorked;
 private double hourlyRate;

 public PartTimeEmployee(String empId, String name, int hoursWorked, double hourlyRate) {
     super( empId,name);
     this.hoursWorked = hoursWorked;
     this.hourlyRate = hourlyRate;
 }

 @Override
 public double calculateSalary() {
     return hoursWorked * hourlyRate;
 }
}