package com.shivam.monocept.studentcourse.validation;


	public class InputValidation {

	    public static String validateStudent(
	            String name,
	            String email,
	            String phone,
	            int age,
	            String city) {

	      
	        if(name == null || name.trim().isEmpty()||!name.matches("^[A-Za-z ]+$")) {
	            return "Name cannot be empty";
	        }

	        if(email == null || !email.contains("@")) {
	            return "Invalid email";
	        }

	     
	        if(phone == null || phone.length() != 10) {
	            return "Phone number must be 10 digits";
	        }

	       
	        if(age < 18) {
	            return "Age must be 18 or above";
	        }

	      
	        if(city == null || city.trim().isEmpty()) {
	            return "City cannot be empty";
	        }

	        return null; 
	    }
	}

