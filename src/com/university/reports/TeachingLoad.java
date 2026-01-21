package com.university.reports;

import com.university.models.Instructor;
import com.university.models.Course;
import java.util.List;

public class TeachingLoad extends Report {
    private Instructor instructor;
    private List<Course> courses;

    public TeachingLoad(String reportId, String generatedDate, Instructor instructor, List<Course> courses) {
        super(reportId, "Teaching Load", generatedDate);
        this.instructor = instructor;
        this.courses = courses;
    }

    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(formatHeader());
        sb.append("Instructor: ").append(instructor.getFullName()).append("\n");
        sb.append("Department: ").append(instructor.getDepartment()).append("\n");
        sb.append("------------------------------------------\n");
        sb.append(String.format("%-10s %-30s %-5s\n", "Code", "Title", "Credits"));
        sb.append("------------------------------------------\n");

        int totalCredits = 0;
        for (Course c : courses) {
            sb.append(String.format("%-10s %-30s %-5d\n", c.getCourseCode(), c.getTitle(), c.getCredits()));
            totalCredits += c.getCredits();
        }
        sb.append("------------------------------------------\n");
        sb.append("Total Credits: ").append(totalCredits).append("\n");
        return sb.toString();
    }

    @Override
    public String getReportType() {
        return "TEACHING_LOAD";
    }

    @Override
    public boolean validate() {
        return instructor != null && courses != null;
    }
}
