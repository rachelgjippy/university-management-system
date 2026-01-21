package com.university.models;

public class NumericalGradeCalculator extends GradeCalculator {

    public NumericalGradeCalculator(String courseCode, String studentId) {
        super(courseCode, studentId);
    }

    @Override
    public String calculateGrade(double score) {
        return String.valueOf(score);
    }

    @Override
    public double calculateGPA(String grade) {
        // Convert raw score to 4.0 scale roughly?
        // Or specific logic.
        // Instructions: "calculateGPA() (convert to 4.0 scale)"
        try {
            double score = Double.parseDouble(grade);
            if (score >= 90)
                return 4.0;
            if (score >= 80)
                return 3.0;
            if (score >= 70)
                return 2.0;
            if (score >= 60)
                return 1.0;
            return 0.0;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    @Override
    public boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }
}
