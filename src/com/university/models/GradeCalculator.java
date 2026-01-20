package com.university.models;

/**
 * Abstract base class for different grading schemes.
 * Demonstrates ABSTRACTION and POLYMORPHISM.
 * 
 * TODO: Create concrete implementations (LetterGradeCalculator, PassFailCalculator, NumericalGradeCalculator).
 */
public abstract class GradeCalculator {
    protected String courseCode;
    protected String studentId;

    public GradeCalculator(String courseCode, String studentId) {
        this.courseCode = courseCode;
        this.studentId = studentId;
    }

    /**
     * Calculate the grade based on the score.
     * Each grading scheme implements this differently (POLYMORPHISM).
     * 
     * @param score The numerical score (0-100)
     * @return The calculated grade as a string
     */
    public abstract String calculateGrade(double score);

    /**
     * Calculate GPA contribution for this grade.
     * 
     * @param grade The grade string
     * @return The GPA points (0.0 - 4.0)
     */
    public abstract double calculateGPA(String grade);

    /**
     * Validate if a score is valid for this grading scheme.
     * 
     * @param score The score to validate
     * @return true if valid, false otherwise
     */
    public abstract boolean isValidScore(double score);

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentId() {
        return studentId;
    }
}
