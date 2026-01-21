package com.university.reports;

import com.university.models.Student;
import com.university.models.Grade;
import com.university.models.Course;
import java.util.List;

public class Transcript extends Report {
    private Student student;
    private List<Grade> grades;
    // We might need Course info to show titles

    public Transcript(String reportId, String generatedDate, Student student, List<Grade> grades) {
        super(reportId, "Official Transcript", generatedDate);
        this.student = student;
        this.grades = grades;
    }

    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(formatHeader());
        sb.append("Student: ").append(student.getFullName()).append(" (").append(student.getStudentId()).append(")\n");
        sb.append("Program: ").append(student.getProgram()).append("\n");
        sb.append("GPA: ").append(String.format("%.2f", student.getGpa())).append("\n");
        sb.append("------------------------------------------\n");
        sb.append(String.format("%-10s %-30s %-5s\n", "Code", "Semester", "Grade"));
        sb.append("------------------------------------------\n");

        for (Grade g : grades) {
            sb.append(String.format("%-10s %-30s %-5s\n",
                    g.getCourseCode(), g.getSemester(), g.getLetterGrade()));
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    @Override
    public String getReportType() {
        return "TRANSCRIPT";
    }

    @Override
    public boolean validate() {
        return student != null;
    }
}
