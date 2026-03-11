package com.shivam.monocept.arrayofobj.model1;

public class Employee {

    protected  final int employeeId;
    protected String name;

    protected static int counter = 0;  

    public Employee(String name) {
        counter++;
        this.employeeId = counter;
        this.name = name;
    }

   
    public double calculateSalary() {
        return 0;
    }

    public double calculateSalary(double bonus) {
        return calculateSalary() + bonus;
    }

     public void displayDetails() {
    	 
     }

    public static int getTotalEmployees() {
        return counter;
    }
}