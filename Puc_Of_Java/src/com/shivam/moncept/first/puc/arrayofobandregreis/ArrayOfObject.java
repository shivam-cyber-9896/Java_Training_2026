package com.shivam.moncept.first.puc.arrayofobandregreis;
class Student {

    int rollNo;
    String name;
    double marks;

    
    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

   
    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("---------------------");
    }
}
public class ArrayOfObject {

    public static void main(String[] args) {

    
        Student[] students = new Student[3];

        students[0] = new Student(1, "Shivam", 85.5);
        students[1] = new Student(2, "Rahul", 90.0);
        students[2] = new Student(3, "Aman", 78.5);

        
        for (int i = 0; i < students.length; i++) {
            students[i].display();
        }
    }
}
