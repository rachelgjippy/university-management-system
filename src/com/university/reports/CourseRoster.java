package com.university.reports;

import com.university.models.Course;
import com.university.models.Student;
import java.util.List;

public class CourseRoster extends Report {
    private Course course;
    private List<Student> students;

    public CourseRoster(String reportId, String generatedDate, Course course, List<Student> students) {
        super(reportId, "Course Roster", generatedDate);
        this.course = course;
        this.students = students;
    }

    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(formatHeader());
        sb.append("Course: ").append(course.getCourseCode()).append(" - ").append(course.getTitle()).append("\n");
        sb.append("Instructor: ").append(course.getInstructorId()).append("\n");
        sb.append("Enrolled: ").append(students.size()).append(" / ").append(course.getCapacity()).append("\n");
        sb.append("------------------------------------------\n");
        sb.append(String.format("%-15s %-30s\n", "ID", "Name"));
        sb.append("------------------------------------------\n");

        for (Student s : students) {
            sb.append(String.format("%-15s %-30s\n", s.getStudentId(), s.getFullName()));
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    @Override
    public String getReportType() {
        return "ROSTER";
    }

    @Override
    public boolean validate() {
        return course != null && students != null;
    }
}
