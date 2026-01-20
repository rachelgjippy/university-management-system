package com.university.repositories;

import com.university.models.*;
import java.util.List;

/**
 * Interface for data persistence operations.
 * Demonstrates ABSTRACTION - hides implementation details of how data is
 * stored.
 * 
 * TODO: Implement this interface with FileRepository for file-based storage.
 */
public interface DataRepository {

    // User operations
    boolean saveUser(User user);

    User getUserById(String userId);

    List<User> getAllUsers();

    boolean updateUser(User user);

    boolean deleteUser(String userId);

    // Course operations
    boolean saveCourse(Course course);

    Course getCourseByCode(String courseCode);

    List<Course> getAllCourses();

    boolean updateCourse(Course course);

    boolean deleteCourse(String courseCode);

    // Enrollment operations
    boolean saveEnrollment(Enrollment enrollment);

    Enrollment getEnrollmentById(String enrollmentId);

    List<Enrollment> getEnrollmentsByStudent(String studentId);

    List<Enrollment> getEnrollmentsByCourse(String courseCode);

    boolean updateEnrollment(Enrollment enrollment);

    boolean deleteEnrollment(String enrollmentId);

    // Grade operations
    boolean saveGrade(Grade grade);

    Grade getGradeById(String gradeId);

    List<Grade> getGradesByStudent(String studentId);

    List<Grade> getGradesByCourse(String courseCode);

    boolean updateGrade(Grade grade);

    boolean deleteGrade(String gradeId);

    // Utility operations
    /**
     * Load all data from storage.
     * 
     * @return true if successful, false otherwise
     */
    boolean loadAllData();

    /**
     * Save all data to storage.
     * 
     * @return true if successful, false otherwise
     */
    boolean saveAllData();

    /**
     * Clear all data from memory (not from storage).
     */
    void clearData();
}
