package com.shivam.monocept.institute.input;

import java.util.Scanner;

public class Inputhandler {

   
    public String nameInput(Scanner scanner) {
        while (true) {
           
            String name = scanner.nextLine();

            if (name != null && name.matches("[a-zA-Z ]+")) {
                return name;
            } else {
                System.out.println("Invalid name (only letters allowed)");
            }
        }
    }

  
    public int ageInput(Scanner scanner) {
        while (true) {
          
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                int age = Integer.parseInt(input);
                if (age > 0 && age <= 120)
                    return age;
            }
            System.out.println("Invalid age (1–120 only)");
        }
    }

  
    public double feeInput(Scanner scanner) {
        while (true) {
           
            String input = scanner.nextLine();

            try {
                double fee = Double.parseDouble(input);
                if (fee > 0)
                    return fee;
            } catch (Exception e) {}

            System.out.println("Invalid fee (must be > 0)");
        }
    }
    public int idInput(Scanner scanner) {
        while (true) {
          
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                int id = Integer.parseInt(input);

                if (id > 0) {
                    return id;
                }
            }

            System.out.println("Invalid ID (must be positive integer)");
        }
    }
    public int IntegerInput(Scanner scanner) {
        while (true) {
           
            String branch = scanner.nextLine();

           
            if (branch != null && !branch.trim().isEmpty()) {

                branch = branch.trim();

               if(branch.matches("\\d+"))
                 return Integer.parseInt(branch) ;
                 
                    System.out.println("Invalid only Integer numbers allowed)");
                

            } else {
                System.out.println("This cannot be empty");
            }
        }
    }
    public String InputString(Scanner scanner) {

        while (true) {

            String branch = scanner.nextLine();

            if (branch != null && !branch.trim().isEmpty()) 
                     branch = branch.trim();

               
                if (branch.matches("[a-zA-Z ]+")) 
                    return branch; 
            System.out.println("Enter a vaild input");
    }
}
}