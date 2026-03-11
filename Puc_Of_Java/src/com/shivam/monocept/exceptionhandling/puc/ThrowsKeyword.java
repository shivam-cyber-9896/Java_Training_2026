package com.shivam.monocept.exceptionhandling.puc;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsKeyword {

    // Using throws keyword
    static void readFile() throws IOException {

        FileReader file = new FileReader("abc.txt");
        System.out.println("File opened successfully");
    }
    static int divide() throws  ArithmeticException{
    	int a=10;
    	return a/0;
    }

    public static void main(String[] args) {

        try {
        	
            readFile();
           
        } 
        catch (IOException e) {
            System.out.println("File not found");
        }
        try {
        	 System.out.println(divide());
        }
       catch(Exception e) {
    	   System.out.print(e);
    	   e.printStackTrace();
       }
        System.out.println("Program continues...");
    }
}