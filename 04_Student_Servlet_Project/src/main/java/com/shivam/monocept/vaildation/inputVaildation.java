package com.shivam.monocept.vaildation;

public class inputVaildation {
	public static String validate(String name, String email, int age, String course, String batch) {

        if (name == null || name.trim().isEmpty() || !name.matches("[a-zA-Z ]+")) {
            return "Enter a valid name (letters only)";
        }
        else if (email == null || email.trim().isEmpty()) {
            return "Email is required";
        }
        else if (age < 18) {
            return "Age must be 18+";
        }
        else if (course == null || course.trim().isEmpty()) {
            return "Select a course";
        }
        else if (batch == null || batch.trim().isEmpty()) {
            return "Select batch time";
        }

        return null;
    }
}
