package com.university.reports;

import com.university.services.UserManager;
import com.university.services.CourseManager;
import com.university.services.GradeManager;
import com.university.services.EnrollmentManager;
import com.university.models.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class ReportManager implements ReportGenerator {
    private UserManager userManager;
    private CourseManager courseManager;
    private GradeManager gradeManager;
    private EnrollmentManager enrollmentManager;

    public ReportManager(UserManager userManager, CourseManager courseManager,
            GradeManager gradeManager, EnrollmentManager enrollmentManager) {
        this.userManager = userManager;
        this.courseManager = courseManager;
        this.gradeManager = gradeManager;
        this.enrollmentManager = enrollmentManager;
    }

    @Override
    public Report generateTranscript(String studentId) {
        Optional<User> userOpt = userManager.getUserById(studentId);
        if (userOpt.isPresent() && userOpt.get() instanceof Student) {
            Student student = (Student) userOpt.get();
            List<Grade> grades = gradeManager.getStudentGrades(studentId);
            return new Transcript("R" + System.currentTimeMillis(), new Date().toString(), student, grades);
        }
        return null;
    }

    @Override
    public Report generateCourseRoster(String courseCode) {
        Optional<Course> courseOpt = courseManager.getCourseByCode(courseCode);
        if (courseOpt.isPresent()) {
            Course course = courseOpt.get();
            List<Enrollment> enrollments = enrollmentManager.getCourseEnrollments(courseCode);
            List<Student> students = new ArrayList<>();

            for (Enrollment e : enrollments) {
                if (e.getStatus().equals("ACTIVE")) {
                    Optional<User> user = userManager.getUserById(e.getStudentId());
                    user.ifPresent(u -> {
                        if (u instanceof Student)
                            students.add((Student) u);
                    });
                }
            }
            return new CourseRoster("R" + System.currentTimeMillis(), new Date().toString(), course, students);
        }
        return null;
    }

    @Override
    public Report generateTeachingLoad(String instructorId) {
        Optional<User> userOpt = userManager.getUserById(instructorId);
        if (userOpt.isPresent() && userOpt.get() instanceof Instructor) {
            Instructor instructor = (Instructor) userOpt.get();
            List<Course> courses = courseManager.getCoursesByInstructor(instructorId);
            return new TeachingLoad("R" + System.currentTimeMillis(), new Date().toString(), instructor, courses);
        }
        return null;
    }

    @Override
    public Report generateDepartmentSummary(String department) {
        List<Course> courses = courseManager.getCoursesByDepartment(department);
        // This logic heavily depends on how we filter by department.
        // For now using simple counts.
        int totalCourses = courses.size();

        // This is inefficient but functional for small scale
        long instructorCount = userManager.getAllUsers().stream()
                .filter(u -> u instanceof Instructor && ((Instructor) u).getDepartment().equals(department))
                .count();

        // Total enrollments in department courses
        int totalEnrollments = 0;
        for (Course c : courses) {
            totalEnrollments += c.getEnrolledCount();
        }

        return new DepartmentSummary("R" + System.currentTimeMillis(), new Date().toString(),
                department, totalCourses, totalEnrollments, (int) instructorCount);
    }

    @Override
    public boolean saveReport(Report report, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(report.generateReport());
            return true;
        } catch (IOException e) {
            System.err.println("Error saving report: " + e.getMessage());
            return false;
        }
    }
}
