package com.university.models;

/**
 * Abstract base class for all users in the system.
 * Demonstrates INHERITANCE and ABSTRACTION.
 * 
 * TODO: Students should extend this class to create Student, Instructor, and Admin classes.
 */
public abstract class User {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String fullName;

    public User(String userId, String username, String password, String email, String fullName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    // Getters and setters (ENCAPSULATION)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Abstract method to display user information.
     * Each subclass must implement this method differently (POLYMORPHISM).
     */
    public abstract void displayInfo();

    /**
     * Abstract method to get user role.
     * @return The role of the user (e.g., "STUDENT", "INSTRUCTOR", "ADMIN")
     */
    public abstract String getRole();

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
