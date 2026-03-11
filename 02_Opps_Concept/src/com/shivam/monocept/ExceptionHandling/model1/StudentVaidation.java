package com.shivam.monocept.ExceptionHandling.model1;



class InvalidMarksException extends Exception {

    public InvalidMarksException(String message) {
        super(message);
    }
}

public class StudentVaidation {
 public static void vaildateMarksNames(double Marks,String Name) throws InvalidMarksException
 {
	 if (Name == null) {
         throw new NullPointerException("Student name cannot be null.");
     }
	 if (Marks < 0 || Marks > 100) {
         throw new InvalidMarksException(
                 "Marks must be between 0 and 100.");
     }
	 System.out.println("Student Name: " + Name);
     System.out.println("Marks: " + Marks);

     if (Marks >= 90)
         System.out.println("Grade: A");
     if (Marks >= 75 && Marks<90)
         System.out.println("Grade: B");
      if (Marks >= 50 && Marks<75)
         System.out.println("Grade: C");
 
         System.out.println("Grade: Fail");
 }
}
