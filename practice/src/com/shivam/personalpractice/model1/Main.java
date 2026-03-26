package com.shivam.personalpractice.model1;

import java.io.*;

class Student implements Serializable {
    int id;
    String name;

   Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        Student s = new Student(1, "Shivam");

        FileOutputStream fos = new FileOutputStream("student.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(s);   

        oos.close();
        fos.close();

        System.out.println("Object Serialized");
        FileInputStream fis = new FileInputStream("student.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student s1 = (Student) ois.readObject();

        System.out.println(s1.id + " " + s1.name);

        ois.close();
        fis.close();
        
    }
}