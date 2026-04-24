package com.shivam.monocept.password;

public class PasswordVaidater {
	public boolean isValid(String password) {
        if (password == null || password.isEmpty()) return false;
        if (password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) 
            	hasUpper = true;
            if (Character.isDigit(c)) 
            	hasDigit = true;
        }
        return hasUpper && hasDigit;
    }

}
