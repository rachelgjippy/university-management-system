package com.university.notifications;

/**
 * Abstract base class for all notification types.
 * Demonstrates ABSTRACTION and POLYMORPHISM.
 * 
 * TODO: Create concrete implementations (EmailNotification, SMSNotification, InAppNotification).
 */
public abstract class Notification {
    protected String notificationId;
    protected String recipient;
    protected String subject;
    protected String message;
    protected String timestamp;

    public Notification(String notificationId, String recipient, String subject, String message, String timestamp) {
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
        this.timestamp = timestamp;
    }

    /**
     * Send the notification using the specific channel.
     * Each notification type implements this differently (POLYMORPHISM).
     * 
     * @return true if sent successfully, false otherwise
     */
    public abstract boolean send();

    /**
     * Get the notification type (e.g., "EMAIL", "SMS", "IN_APP").
     * 
     * @return The notification type as a string
     */
    public abstract String getNotificationType();

    /**
     * Format the notification message for display.
     * 
     * @return Formatted message string
     */
    public abstract String formatMessage();

    // Getters and setters
    public String getNotificationId() {
        return notificationId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
