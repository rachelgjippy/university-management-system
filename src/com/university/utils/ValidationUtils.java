package com.university.utils;

/**
 * Utility class for input validation.
 * Demonstrates ENCAPSULATION - validation logic is centralized and hidden.
 */
public class ValidationUtils {
    
    /**
     * Validate email format.
     * 
     * @param email The email to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    /**
     * Validate that a string is not null or empty.
     * 
     * @param value The string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    /**
     * Validate that a number is positive.
     * 
     * @param value The number to validate
     * @return true if positive, false otherwise
     */
    public static boolean isPositive(int value) {
        return value > 0;
    }
    
    /**
     * Validate that a score is within valid range (0-100).
     * 
     * @param score The score to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }
    
    /**
     * Validate course code format (e.g., "CS101", "MATH202").
     * 
     * @param courseCode The course code to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidCourseCode(String courseCode) {
        if (courseCode == null || courseCode.isEmpty()) {
            return false;
        }
        return courseCode.matches("^[A-Z]{2,4}\\d{3}$");
    }
    
    /**
     * Validate user ID format.
     * 
     * @param userId The user ID to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidUserId(String userId) {
        if (userId == null || userId.isEmpty()) {
            return false;
        }
        return userId.length() >= 3 && userId.length() <= 20;
    }
}
