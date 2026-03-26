package com.shivam.monocept.game.model1.input;

import java.util.Scanner;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);
     int digit;
     String type;
    public int getRow() {
        System.out.println("Enter Row:");
            type= scanner.nextLine();
		while(type==null||type.trim().isEmpty()||!type.matches("^[1-9]$")) {
			 System.out.println("Enter Vaild  Row:");
			 
		   type= scanner.nextLine();
		}
		return Integer.parseInt(type);
		
    }

    public int getColumn() {
        System.out.println("Enter Column:");
        type= scanner.nextLine();
	while(type==null||type.trim().isEmpty()||!type.matches("^[1-9]$")) {
		 System.out.println("Enter Vaild  Column:");
		  type= scanner.nextLine();
	}
	return Integer.parseInt(type);
    }

    public int getNumber() {
    	System.out.println("Enter a number");
    	 type= scanner.nextLine();
    		while(type==null||type.trim().isEmpty()||!type.matches("^[1-9]$")) {
    			 System.out.println("Enter Vaild  Number:");
    			 type= scanner.nextLine();
    		}
    		return Integer.parseInt(type);       
    }
}