package com.university.notifications;

public class InAppNotification extends Notification {

    public InAppNotification(String notificationId, String recipient, String subject, String message,
            String timestamp) {
        super(notificationId, recipient, subject, message, timestamp);
    }

    @Override
    public boolean send() {
        System.out.println("[APP] Notification for " + recipient + ": " + subject);
        return true;
    }

    @Override
    public String getNotificationType() {
        return "IN_APP";
    }

    @Override
    public String formatMessage() {
        return subject + ": " + message;
    }
}
