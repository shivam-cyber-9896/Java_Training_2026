package com.shivam.monocept.paitent.model1;

public class EmailService implements NotificationService {
    public void sendEmail(Patient patient) {
        System.out.println("Sending email for patient: " + patient.getName());
    }
}