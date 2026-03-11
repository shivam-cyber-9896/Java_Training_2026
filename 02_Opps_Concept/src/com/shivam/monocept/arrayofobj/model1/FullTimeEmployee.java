package com.shivam.monocept.arrayofobj.model1;

public class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);   // Constructor chaining
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void displayDetails() {
        System.out.println("Full Time Employee: " + name +
                " | Salary: " + calculateSalary());
    }
}