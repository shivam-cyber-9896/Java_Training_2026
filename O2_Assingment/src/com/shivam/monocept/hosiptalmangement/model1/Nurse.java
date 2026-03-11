package com.shivam.monocept.hosiptalmangement.model1;

public class Nurse extends Staff {

    private String shift;

    public Nurse(String name, String department, String shift) {
        super(name, department);
        this.shift = shift;
    }

    @Override
    public void showDetails() {
        System.out.println("----- Nurse Details -----");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Shift: " + shift);
    }
}
