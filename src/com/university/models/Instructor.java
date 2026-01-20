package com.university.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Instructor user in the system.
 */
public class Instructor extends User {
    private String instructorId;
    private String department;
    private String officeHours;
    private List<String> coursesTaught; // List of course codes

    public Instructor(String userId, String username, String password, String email,
            String fullName, String instructorId, String department, String officeHours) {
        super(userId, username, password, email, fullName);
        this.instructorId = instructorId;
        this.department = department;
        this.officeHours = officeHours;
        this.coursesTaught = new ArrayList<>();
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public List<String> getCoursesTaught() {
        return new ArrayList<>(coursesTaught);
    }

    public void addCourse(String courseCode) {
        if (!coursesTaught.contains(courseCode)) {
            coursesTaught.add(courseCode);
        }
    }

    public void removeCourse(String courseCode) {
        coursesTaught.remove(courseCode);
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========== INSTRUCTOR INFORMATION ==========");
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Name: " + getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + department);
        System.out.println("Office Hours: " + officeHours);
        System.out.println("Courses Taught: " + coursesTaught.size());
        System.out.println("============================================\n");
    }

    @Override
    public String getRole() {
        return "INSTRUCTOR";
    }
}
