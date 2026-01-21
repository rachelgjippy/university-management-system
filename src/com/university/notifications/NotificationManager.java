package com.university.notifications;

import java.util.List;
import java.util.Date;

/**
 * Manages notification dispatches.
 */
public class NotificationManager implements NotificationService {

    @Override
    public boolean sendNotification(Notification notification) {
        return notification.send();
    }

    @Override
    public void notifyEnrollment(String studentId, String courseCode) {
        String timestamp = new Date().toString();
        // Simulate looking up student email
        String email = studentId + "@university.com";

        Notification notification = new EmailNotification(
                "N" + System.currentTimeMillis(),
                email,
                "Enrollment Confirmation",
                "You have been successfully enrolled in " + courseCode,
                timestamp);
        sendNotification(notification);
    }

    @Override
    public void notifyGradePosted(String studentId, String courseCode, String grade) {
        String timestamp = new Date().toString();
        // Simulate SMS or App notification
        Notification notification = new InAppNotification(
                "N" + System.currentTimeMillis(),
                studentId,
                "New Grade Posted",
                "Grade for " + courseCode + ": " + grade,
                timestamp);
        sendNotification(notification);
    }

    @Override
    public void notifyCourseDropped(String studentId, String courseCode) {
        String timestamp = new Date().toString();
        String email = studentId + "@university.com";

        Notification notification = new EmailNotification(
                "N" + System.currentTimeMillis(),
                email,
                "Course Dropped",
                "You have dropped " + courseCode,
                timestamp);
        sendNotification(notification);
    }

    @Override
    public void sendAnnouncement(List<String> recipientIds, String subject, String message) {
        String timestamp = new Date().toString();
        for (String recipient : recipientIds) {
            String email = recipient + "@university.com";
            Notification notification = new EmailNotification(
                    "N" + System.currentTimeMillis() + recipient.hashCode(),
                    email,
                    subject,
                    message,
                    timestamp);
            sendNotification(notification);
        }
    }
}
