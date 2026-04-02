package com.shivam.personalpractice.model1;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class A {
    static void show(){
        System.out.print("A ");
    }
}

class B extends A {
    static void show(){
        System.out.print("B ");
    }
}


 public class TestPro {
    public static void main(String[] args){  
    	B obj = new B();
        obj.show(); 
}
 }

    	
    	
    	        