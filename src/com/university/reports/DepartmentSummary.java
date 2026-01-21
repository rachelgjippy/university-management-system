package com.university.reports;

import java.util.Map;

public class DepartmentSummary extends Report {
    private String department;
    private int totalCourses;
    private int totalStudents;
    private int totalInstructors;

    public DepartmentSummary(String reportId, String generatedDate, String department,
            int totalCourses, int totalStudents, int totalInstructors) {
        super(reportId, "Department Summary", generatedDate);
        this.department = department;
        this.totalCourses = totalCourses;
        this.totalStudents = totalStudents;
        this.totalInstructors = totalInstructors;
    }

    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(formatHeader());
        sb.append("Department: ").append(department).append("\n");
        sb.append("------------------------------------------\n");
        sb.append("Total Courses: ").append(totalCourses).append("\n");
        sb.append("Total Instructors: ").append(totalInstructors).append("\n");
        sb.append("Total Students Enrolled: ").append(totalStudents).append("\n"); // Approximation
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    @Override
    public String getReportType() {
        return "DEPARTMENT_SUMMARY";
    }

    @Override
    public boolean validate() {
        return department != null && !department.isEmpty();
    }
}
