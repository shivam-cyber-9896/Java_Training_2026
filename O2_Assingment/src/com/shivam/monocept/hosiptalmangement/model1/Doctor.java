package com.shivam.monocept.hosiptalmangement.model1;

public class Doctor extends Staff {

    private String specialization;

    public Doctor(String name, String department, String specialization) {
        super(name, department);
        this.specialization = specialization;
    }

    @Override
    public void showDetails() {
        System.out.println("----- Doctor Details -----");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
        System.out.println("Specialization: " + specialization);
    }
}


