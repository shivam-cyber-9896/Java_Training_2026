package com.shivam.moncept.interfacepuc;

import java.util.Scanner;
interface Demo {

    static void print() {
        helper();
    }

    private static void helper() {
        System.out.println("Private static method");
    }
}
interface A {
    void show();

    default int add(int a, int b) {
        return a + b;
    }
}

interface B {
    void show();

    default int sub(int a, int b) {
        return a - b;
    }

    static void add2() {
        System.out.println("Call static method using interface name");
    }
}

public class HowToCreate implements A, B ,Demo{

    public static void main(String[] args) {

        HowToCreate x = new HowToCreate();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        int num1 = scanner.nextInt();

        System.out.println("Enter second number:");
        int num2 = scanner.nextInt();

        System.out.println("Addition = " + x.add(num1, num2));
        System.out.println("Subtraction = " + x.sub(num1, num2));

        x.show();

        B.add2();   
        Demo.print();
    }

    @Override
    public void show() {
        System.out.println("Show method implemented once");
    }
}