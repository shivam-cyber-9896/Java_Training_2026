package com.shivam.monocept.hosiptalmangement.model1;

public abstract class Staff {

    private final int id;
    private final String name;
    private final String department;

    private static int counter = 100;

    public Staff(String name, String department) {
        this.id = counter++;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public abstract void showDetails();
}