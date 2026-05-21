package com.shivam.monocept.studentcourse.validation;


public class CourseValidation {

    public static String validateCourse(
            String courseName,
            String duration,
            double fees,
            String trainerName) {

        // COURSE NAME
        if(courseName == null ||
           courseName.trim().isEmpty()||!courseName.matches("^[A-Za-z ]+$")) {

            return "Course Name Cannot Be Empty";
        }

        if(courseName.length() < 3) {

            return "Course Name Must Be At Least 3 Characters";
        }

        // DURATION
        if(duration == null ||
           duration.trim().isEmpty()|| !duration.matches("^(\\d+\\s(year|years)(\\s\\d+\\s(month|months))?|\\d+\\s(month|months))$") ) {

            return "Duration Cannot Be Empty";
        }

        // FEES
        if(fees <= 0) {

            return "Fees Must Be Greater Than 0";
        }

        // TRAINER NAME
        if(trainerName == null ||
           trainerName.trim().isEmpty()|| !trainerName.matches("^[A-Za-z ]+$")) {

            return "Trainer Name Cannot Be Empty";
        }

        if(trainerName.length() < 3) {

            return "Trainer Name Must Be At Least 3 Characters";
        }

        return null;
    }
}