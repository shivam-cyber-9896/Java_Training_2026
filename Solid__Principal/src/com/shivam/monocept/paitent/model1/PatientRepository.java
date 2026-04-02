package com.shivam.monocept.paitent.model1;

public class PatientRepository {
    public void save(Patient patient) {
        System.out.println("Saving patient to database: " + patient.getName());
    }
}
