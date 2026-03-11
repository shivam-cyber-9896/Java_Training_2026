package com.shivam.monocept.ExceptionHandling.test;

public class ExceptionChainingTest
{

    public static void processPayment() {

        try {
            String paymentMethod = null;

            
            System.out.println(paymentMethod.length());
        }
        catch (NullPointerException e) {

           
            throw new RuntimeException("Payment processing failed!", e);
        }
    }

    public static void main(String[] args) {

        try {
            processPayment();
        }
        catch (RuntimeException e) {

            System.out.println("Final Exception Caught in main():");
            System.out.println("Message: " + e.getMessage());
 }
        

        System.out.println("Program continues safely...");
    }
}