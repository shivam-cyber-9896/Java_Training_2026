package com.shivam.monocept.string.model1;

public class PasswordVaildater {
	 String password ;
	 boolean hasUpper = false;
     boolean hasLower = false;
     boolean hasDigit = false;
	public PasswordVaildater(String password)
	 {
		 this.password=password;
	 }
	public  void vaildate()
	{
		System.out.println("Enter password is = "+password.length());
		if(password.length()<8)
			{
			System.out.println(" Password length is less than 8 "+password.length());
			System.out.println("Invaild Paaword");
			return;
			}
		 for (int i = 0; i < password.length(); i++) {

	            char ch = password.charAt(i);

	       
	            if (Character.isUpperCase(ch)) {
	                hasUpper = true;
	            }

	        
	            if (Character.isLowerCase(ch)) {
	                hasLower = true;
	            }

	     
	            if (Character.isDigit(ch)) {
	                hasDigit = true;
	            }
	            
	            String modifiedPassword = password.replace(" ", "");

	            
	            System.out.println("Password Length: " + password.length());
	            System.out.println("Contains Uppercase: " +hasUpper );
	            System.out.println("Contains Lowercase: " + hasLower);
	            System.out.println("Contains Digit: " + hasDigit);
	            System.out.println("Password after removing spaces: " + modifiedPassword);
	            if(hasUpper==false|| hasLower==false||hasDigit==false)
	            {
	            	System.out.println("Password is in vaild");
	            	return;
	            }
	            System.out.println("Password is  Vaild");
		 }
		
	}
}
