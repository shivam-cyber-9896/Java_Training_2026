package com.shivam.monocept.ExceptionHandling.test;

public class NestedTryCatchExample {

    public static void main(String[] args) {

        try { 
            int result = 10 / 0;   
            System.out.println("Result: " + result);

            try {   
                int arr[] = {1, 2, 3};
                System.out.println(arr[5]);   
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner Catch: Array index is out of bounds!");
            }

        }
        catch (ArithmeticException e) {
            System.out.println("Outer Catch: Cannot divide by zero!");
        }

        System.out.println("Program continues after handling exceptions.");
    }
}