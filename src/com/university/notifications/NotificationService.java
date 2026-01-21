package com.university.notifications;

import java.util.List;

/**
 * Interface for notification operations.
 * Demonstrates ABSTRACTION.
 * 
 * TODO: Implement this interface to manage different notification types.
 */
public interface NotificationService {

    /**
     * Send a notification to a user.
     * 
     * @param notification The notification to send
     * @return true if sent successfully, false otherwise
     */
    boolean sendNotification(Notification notification);

    /**
     * Send enrollment confirmation notification.
     * 
     * @param studentId  The student ID
     * @param courseCode The course code
     */
    void notifyEnrollment(String studentId, String courseCode);

    /**
     * Send grade posted notification.
     * 
     * @param studentId  The student ID
     * @param courseCode The course code
     * @param grade      The grade received
     */
    void notifyGradePosted(String studentId, String courseCode, String grade);

    /**
     * Send course drop notification.
     * 
     * @param studentId  The student ID
     * @param courseCode The course code
     */
    void notifyCourseDropped(String studentId, String courseCode);

    /**
     * Send administrative announcement.
     * 
     * @param recipientIds Array of recipient user IDs
     * @param subject      The announcement subject
     * @param message      The announcement message
     */
    void sendAnnouncement(List<String> recipientIds, String subject, String message);
}
