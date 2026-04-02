package com.shivam.monocept.paitent.model1;

public class PatientReportFormatter {
   public String format(Patient patient) {
        return "Patient Report\nName: " + patient.getName() +
               "\nAge: " + patient.getAge() +
               "\nDisease: " + patient.getDisease();
    }
}