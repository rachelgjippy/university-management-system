package com.university.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Student user in the system.
 * This is an EXAMPLE implementation - students should complete and enhance
 * this.
 * Demonstrates INHERITANCE (extends User) and POLYMORPHISM (overrides methods).
 */
public class Student extends User {
    private String studentId;
    private String program; // e.g., "Computer Science"
    private int year; // e.g., 1, 2, 3, 4
    private double gpa;
    private List<String> completedCourses; // List of course codes

    public Student(String userId, String username, String password, String email,
            String fullName, String studentId, String program, int year) {
        super(userId, username, password, email, fullName);
        this.studentId = studentId;
        this.program = program;
        this.year = year;
        this.gpa = 0.0;
        this.completedCourses = new ArrayList<>();
    }

    // Additional getters and setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1 && year <= 4) {
            this.year = year;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }

    public List<String> getCompletedCourses() {
        return new ArrayList<>(completedCourses);
    }

    /**
     * Add a completed course to the student's record.
     * 
     * @param courseCode The course code to add
     */
    public void addCompletedCourse(String courseCode) {
        if (!completedCourses.contains(courseCode)) {
            completedCourses.add(courseCode);
        }
    }

    /**
     * Check if student has completed a specific course.
     * 
     * @param courseCode The course code to check
     * @return true if completed, false otherwise
     */
    public boolean hasCompletedCourse(String courseCode) {
        return completedCourses.contains(courseCode);
    }

    /**
     * Implementation of abstract method from User class.
     * Demonstrates POLYMORPHISM - different behavior than Instructor or Admin.
     */
    @Override
    public void displayInfo() {
        System.out.println("\n========== STUDENT INFORMATION ==========");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Program: " + program);
        System.out.println("Year: " + year);
        System.out.println("GPA: " + String.format("%.2f", gpa));
        System.out.println("Completed Courses: " + completedCourses.size());
        System.out.println("=========================================\n");
    }

    /**
     * Implementation of abstract method from User class.
     * 
     * @return The role of this user type
     */
    @Override
    public String getRole() {
        return "STUDENT";
    }

    /**
     * Calculate and update GPA based on grades.
     * TODO: This should be called by GradeManager when grades are updated.
     * 
     * @param grades Array of Grade objects for this student
     */
    public void calculateGPA(Grade[] grades) {
        if (grades == null || grades.length == 0) {
            this.gpa = 0.0;
            return;
        }

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Grade grade : grades) {
            if (grade == null)
                continue;

            // Convert letter grade to GPA points
            double gradePoints = convertLetterToGPA(grade.getLetterGrade());

            // In a real system, we would get credits from the Course object
            // identifying the course by grade.getCourseCode()
            // For this project, we'll assume standard 3 credits per course
            int credits = 3;

            totalPoints += gradePoints * credits;
            totalCredits += credits;
        }

        this.gpa = totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    /**
     * Helper method to convert letter grade to GPA points.
     * 
     * @param letterGrade The letter grade (A, B, C, D, F)
     * @return GPA points (4.0 scale)
     */
    private double convertLetterToGPA(String letterGrade) {
        switch (letterGrade.toUpperCase()) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", program='" + program + '\'' +
                ", year=" + year +
                ", gpa=" + gpa +
                '}';
    }
}
