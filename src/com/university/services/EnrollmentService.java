package com.university.services;

import com.university.models.Enrollment;
import java.util.List;

/**
 * Interface for enrollment operations.
 * Demonstrates ABSTRACTION - defines what operations are available without
 * specifying how they work.
 * 
 * TODO: Implement this interface in EnrollmentManager class.
 */
public interface EnrollmentService {

    /**
     * Enroll a student in a course.
     * 
     * @param studentId  The ID of the student
     * @param courseCode The course code
     * @param semester   The semester (e.g., "Fall2024")
     * @return The enrollment record if successful, null otherwise
     */
    Enrollment enrollStudent(String studentId, String courseCode, String semester);

    /**
     * Drop a student from a course.
     * 
     * @param studentId  The ID of the student
     * @param courseCode The course code
     * @return true if successful, false otherwise
     */
    boolean dropCourse(String studentId, String courseCode);

    /**
     * Check if a student meets prerequisites for a course.
     * 
     * @param studentId  The ID of the student
     * @param courseCode The course code
     * @return true if prerequisites are met, false otherwise
     */
    boolean checkPrerequisites(String studentId, String courseCode);

    /**
     * Check if a student has exceeded maximum credit limit.
     * 
     * @param studentId         The ID of the student
     * @param additionalCredits Credits to be added
     * @return true if within limit, false otherwise
     */
    boolean checkCreditLimit(String studentId, int additionalCredits);

    /**
     * Get all enrollments for a student.
     * 
     * @param studentId The ID of the student
     * @return Array of enrollment records
     */
    List<Enrollment> getStudentEnrollments(String studentId);

    /**
     * Get all enrollments for a course.
     * 
     * @param courseCode The course code
     * @return Array of enrollment records
     */
    List<Enrollment> getCourseEnrollments(String courseCode);
}
