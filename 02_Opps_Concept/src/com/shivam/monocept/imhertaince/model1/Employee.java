package com.shivam.monocept.imhertaince.model1;

//Base Class
public abstract class Employee {

 protected String empId;
 protected String name;

 public Employee( String empId,String name) {
     this.empId=empId;
     this.name = name;
 }

  public abstract double calculateSalary();

 public void displayEmployee() {
     System.out.println("Employee ID: " + empId);
     System.out.println("Name: " + name);
 }

 public void printPayslip() {
     displayEmployee();
     System.out.println("Salary: ₹" + calculateSalary());
     System.out.println("----------------------------");
 }
}