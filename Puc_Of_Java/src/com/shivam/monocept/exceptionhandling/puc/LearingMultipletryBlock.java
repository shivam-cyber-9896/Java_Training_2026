package com.shivam.monocept.exceptionhandling.puc;

public class LearingMultipletryBlock {
    public static void main(String[] args) {

        
        try {
            int a = 10 / 0;
        } 
        catch (Exception e) {
            System.out.println("Cannot divide by zero"+e);
        }

       
        try {
            String name = null;
            System.out.println(name.length());
        } 
        catch (NullPointerException e) {
            System.out.println("String is null");
        }

        System.out.println("Program Completed");
    }
}