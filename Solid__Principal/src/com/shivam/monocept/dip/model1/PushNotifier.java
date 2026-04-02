package com.shivam.monocept.dip.model1;

public class PushNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Push notification: " + message);
    }
}
