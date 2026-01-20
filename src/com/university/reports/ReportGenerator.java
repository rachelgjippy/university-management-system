package com.university.reports;

/**
 * Interface for report generation operations.
 * Demonstrates ABSTRACTION.
 * 
 * TODO: Implement this interface to manage report generation.
 */
public interface ReportGenerator {
    
    /**
     * Generate a student transcript.
     * 
     * @param studentId The student ID
     * @return The transcript report
     */
    Report generateTranscript(String studentId);
    
    /**
     * Generate a course roster.
     * 
     * @param courseCode The course code
     * @return The roster report
     */
    Report generateCourseRoster(String courseCode);
    
    /**
     * Generate an instructor teaching load report.
     * 
     * @param instructorId The instructor ID
     * @return The teaching load report
     */
    Report generateTeachingLoad(String instructorId);
    
    /**
     * Generate a department summary report.
     * 
     * @param department The department name
     * @return The department summary report
     */
    Report generateDepartmentSummary(String department);
    
    /**
     * Save a report to file.
     * 
     * @param report The report to save
     * @param filename The filename
     * @return true if saved successfully, false otherwise
     */
    boolean saveReport(Report report, String filename);
}
