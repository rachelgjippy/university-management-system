package com.university.notifications;

public class SMSNotification extends Notification {

    public SMSNotification(String notificationId, String recipient, String message, String timestamp) {
        super(notificationId, recipient, "SMS", message, timestamp);
    }

    @Override
    public boolean send() {
        System.out.println("[SMS] Sending to: " + recipient);
        System.out.println("[SMS] Message: " + message);
        return true;
    }

    @Override
    public String getNotificationType() {
        return "SMS";
    }

    @Override
    public String formatMessage() {
        return "[SMS] " + message;
    }
}
