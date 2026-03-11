package com.shivam.moncept.first.statickeyword;
class Employee {

    // 🔹 Static Variable (Shared by all objects)
    static String companyName;

    // 🔹 Static Block (Executes only once when class loads)
    static {
        System.out.println("Static block executed...");
        companyName = "Monocept Pvt Ltd";
    }

    // 🔹 Instance Variables (Different for each object)
    int id;
    String name;

    // Constructor
    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 🔹 Instance Method
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Company: " + companyName);
       
    }

   
    static void changeCompany(String newCompany) {
        companyName = newCompany;
        System.out.println("Company changed to: " + companyName);
    }
}

public class StaticDemo {

    public static void main(String[] args) {

        System.out.println("Main method started...\n");

        // Creating first object
        Employee emp1 = new Employee(101, "Shivam");
        emp1.display();

        // Creating second object
        Employee emp2 = new Employee(102, "Rahul");
        emp2.display();

        // Calling static method without object
        Employee.changeCompany("Xyz ");

        emp1.display();
        emp2.display();
    }
}
