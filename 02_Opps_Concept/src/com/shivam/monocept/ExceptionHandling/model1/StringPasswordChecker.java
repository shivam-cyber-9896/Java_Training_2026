package com.shivam.monocept.ExceptionHandling.model1;


  
public class StringPasswordChecker {

    
    public static void checkPassword(String pwd) throws InvalidPasswordException {

        if (pwd.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }

        if (!pwd.matches(".*\\d.*")) { 
            throw new InvalidPasswordException("Password must contain at least one digit.");
        }

        System.out.println("Password is valid ✅");
    }
}