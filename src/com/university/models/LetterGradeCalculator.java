package com.university.models;

public class LetterGradeCalculator extends GradeCalculator {

    public LetterGradeCalculator(String courseCode, String studentId) {
        super(courseCode, studentId);
    }

    @Override
    public String calculateGrade(double score) {
        if (score >= 90)
            return "A";
        if (score >= 80)
            return "B";
        if (score >= 70)
            return "C";
        if (score >= 60)
            return "D";
        return "F";
    }

    @Override
    public double calculateGPA(String grade) {
        switch (grade.toUpperCase()) {
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
    public boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }
}
