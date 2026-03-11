package com.shivam.monocept.imhertaince.model1;



public class EmailNotification extends Notification {

    public EmailNotification(String recipient, String message) {
        super(recipient, message);   // Constructor chaining
    }

    @Override
    public void send() {
        super.logNotification();     // Call parent method
        System.out.println("Email sent to " + recipient);
        System.out.println("Message: " + message);
    }
}