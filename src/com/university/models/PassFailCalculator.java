package com.university.models;

public class PassFailCalculator extends GradeCalculator {

    public PassFailCalculator(String courseCode, String studentId) {
        super(courseCode, studentId);
    }

    @Override
    public String calculateGrade(double score) {
        return score >= 60 ? "PASS" : "FAIL";
    }

    @Override
    public double calculateGPA(String grade) {
        // Pass/Fail usually doesn't affect GPA points directly like letter grades,
        // but for this simplified model we might return 0 or 4.0?
        // Actually, P/F usually means no GPA effect.
        // But the requirement says: "Pass: credit earned, Fail: 0"
        // Let's assume Pass counts as full points for now or handle it elsewhere.
        // However, the interface demands a double return.
        // Instructions: "Pass: credit earned, Fail: 0" -> this sounds like credits, not
        // GPA.
        // But for GPA calculation in Student.java, we sum (points * credits).
        // If Pass is just credit, points might be ignored or treated as 0.0?
        // Let's return 0.0 for now as standard P/F often doesn't impact GPA.
        return 0.0;
    }

    @Override
    public boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }
}
