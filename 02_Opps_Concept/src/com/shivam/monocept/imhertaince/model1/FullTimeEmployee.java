package com.shivam.monocept.imhertaince.model1;
public class FullTimeEmployee extends Employee {

 private double basic;
 private double hra;
 private double da;

 public FullTimeEmployee(String empId, String name, double basic, double hra, double da) {
     super(empId, name);
     this.basic = basic;
     this.hra = hra;
     this.da = da;
 }

 @Override
 public double calculateSalary() {
     return basic + hra + da;
 }
}