package com.shivam.personalpractice.model1;

import java.io.*;

class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }
}

public class Tcgvest {
    public static void main(String[] args) throws Exception {

        // Serialization
        Student s1 = new Student(101, "Shivam");
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data.ser"));
        oos.writeObject(s1);
        oos.close();

        // Deserialization
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("data.ser"));
        Student s2 =  (Student) ois.readObject();

        System.out.println(s2);  // ✅ prints properly
    }
}