package com.shivam.monocept.arrayofobj.model1;

public class Intern extends Employee {

    private double stipend;

    public Intern(String name, double stipend) {
        super(name);  
        this.stipend = stipend;
    }

    @Override
    public double calculateSalary() {
        return stipend;
    }

    @Override
    public void displayDetails() {
        System.out.println("Intern: " + name +
                " | Salary: " + calculateSalary());
    }
}