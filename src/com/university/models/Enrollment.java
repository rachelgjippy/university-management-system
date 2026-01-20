package com.university.models;

/**
 * Represents an enrollment record linking a student to a course.
 * 
 * TODO: Add enrollment status and timestamp tracking.
 */
public class Enrollment {
    private String enrollmentId;
    private String studentId;
    private String courseCode;
    private String semester;
    private String status; // "ACTIVE", "DROPPED", "COMPLETED"

    public Enrollment(String enrollmentId, String studentId, String courseCode, String semester) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.status = "ACTIVE";
    }

    // Getters and setters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", semester='" + semester + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
