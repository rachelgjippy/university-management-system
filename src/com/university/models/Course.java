package com.university.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a course in the university system.
 * Demonstrates ENCAPSULATION.
 * 
 * TODO: Add validation methods and business logic for course management.
 */
public class Course {
    private String courseCode;
    private String title;
    private int credits;
    private String instructorId;
    private int capacity;
    private List<String> enrolledStudents;
    private List<String> prerequisites;

    public Course(String courseCode, String title, int credits, String instructorId, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.instructorId = instructorId;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.prerequisites = new ArrayList<>();
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be positive.");
        }
        this.credits = credits;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
    }

    public List<String> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents); // Return copy to protect internal list
    }

    public List<String> getPrerequisites() {
        return new ArrayList<>(prerequisites); // Return copy to protect internal list
    }

    public void addPrerequisite(String courseCode) {
        if (!prerequisites.contains(courseCode)) {
            prerequisites.add(courseCode);
        }
    }

    /**
     * Check if the course is full.
     * 
     * @return true if course is at capacity, false otherwise
     */
    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    /**
     * Add a student to the course.
     * 
     * @param studentId The ID of the student to add
     * @return true if student was added, false if course is full
     */
    public boolean addStudent(String studentId) {
        if (!isFull() && !enrolledStudents.contains(studentId)) {
            enrolledStudents.add(studentId);
            return true;
        }
        return false;
    }

    /**
     * Remove a student from the course.
     * 
     * @param studentId The ID of the student to remove
     * @return true if student was removed, false if student was not enrolled
     */
    public boolean removeStudent(String studentId) {
        return enrolledStudents.remove(studentId);
    }

    public int getEnrolledCount() {
        return enrolledStudents.size();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                ", capacity=" + capacity +
                ", enrolled=" + enrolledStudents.size() +
                '}';
    }
}
