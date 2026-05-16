package com.shivam.monocept.studentcourse.validation;

public class RegistrationValidation {

    public static String validateRegistration(
            int studentId,
            int courseId,
            String registrationDate,
            String status) {

        // STUDENT ID
        if(studentId <= 0){

            return "Invalid Student ID";
        }

        // COURSE ID
        if(courseId <= 0){

            return "Invalid Course ID";
        }

        // REGISTRATION DATE
        if(registrationDate == null ||
           registrationDate.trim().isEmpty()){

            return "Registration Date Cannot Be Empty";
        }

        // STATUS
        if(status == null ||
           status.trim().isEmpty()){

            return "Status Cannot Be Empty";
        }

        // ALLOWED STATUS VALUES
        if(!status.equalsIgnoreCase("Active") &&
           !status.equalsIgnoreCase("Completed") &&
           !status.equalsIgnoreCase("Cancelled")){

            return "Status Must Be Active, Completed or Cancelled";
        }

        return null;
    }
}