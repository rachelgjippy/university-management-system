package com.university.services;

import com.university.models.Enrollment;
import com.university.models.Course;
import com.university.models.Student;
import com.university.models.User;
import com.university.repositories.DataRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Manages enrollment operations.
 */
public class EnrollmentManager implements EnrollmentService {
    private DataRepository repository;
    private CourseManager courseManager;
    private UserManager userManager;

    public EnrollmentManager(DataRepository repository, CourseManager courseManager, UserManager userManager) {
        this.repository = repository;
        this.courseManager = courseManager;
        this.userManager = userManager;
    }

    @Override
    public Enrollment enrollStudent(String studentId, String courseCode, String semester) {
        // 1. Check if course exists
        Optional<Course> courseOpt = courseManager.getCourseByCode(courseCode);
        if (!courseOpt.isPresent()) {
            System.out.println("Error: Course not found.");
            return null;
        }
        Course course = courseOpt.get();

        // 2. Check if student exists
        Optional<User> userOpt = userManager.getUserById(studentId);
        if (!userOpt.isPresent() || !(userOpt.get() instanceof Student)) {
            System.out.println("Error: Student not found.");
            return null;
        }

        // 3. Check if course is full
        if (course.isFull()) {
            System.out.println("Error: Course is full.");
            return null;
        }

        // 4. Check credit limit
        if (!checkCreditLimit(studentId, course.getCredits())) {
            System.out.println("Error: Credit limit exceeded (Max 18).");
            return null;
        }

        // 5. Check prerequisites (simplified: just check if they have taken them)
        if (!checkPrerequisites(studentId, courseCode)) {
            System.out.println("Error: Prerequisites not met.");
            return null;
        }

        // 6. Create enrollment
        String enrollmentId = "E" + System.currentTimeMillis();
        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseCode, semester);
        repository.saveEnrollment(enrollment);

        // 7. Update course enrollment list
        course.addStudent(studentId);
        courseManager.updateCourse(course); // Save updated course state

        System.out.println("Successfully enrolled in " + courseCode);
        return enrollment;
    }

    @Override
    public boolean dropCourse(String studentId, String courseCode) {
        // Find active enrollment
        List<Enrollment> enrollments = repository.getEnrollmentsByStudent(studentId);
        Optional<Enrollment> enrollmentOpt = enrollments.stream()
                .filter(e -> e.getCourseCode().equals(courseCode) && e.getStatus().equals("ACTIVE"))
                .findFirst();

        if (enrollmentOpt.isPresent()) {
            Enrollment enrollment = enrollmentOpt.get();
            enrollment.setStatus("DROPPED");
            repository.updateEnrollment(enrollment);

            // Update course
            Optional<Course> courseOpt = courseManager.getCourseByCode(courseCode);
            if (courseOpt.isPresent()) {
                Course course = courseOpt.get();
                course.removeStudent(studentId);
                courseManager.updateCourse(course);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPrerequisites(String studentId, String courseCode) {
        Optional<Course> courseOpt = courseManager.getCourseByCode(courseCode);
        if (!courseOpt.isPresent())
            return false;

        Course course = courseOpt.get();
        List<String> prerequisites = course.getPrerequisites();

        if (prerequisites.isEmpty())
            return true;

        Optional<User> userOpt = userManager.getUserById(studentId);
        if (!userOpt.isPresent() || !(userOpt.get() instanceof Student))
            return false;

        Student student = (Student) userOpt.get();

        for (String prereq : prerequisites) {
            if (!student.hasCompletedCourse(prereq)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkCreditLimit(String studentId, int additionalCredits) {
        // Calculate current credits for this semester
        // For simplicity, we assume all active enrollments count towards the limit
        // In a real app, we would filter by current semester
        List<Enrollment> activeEnrollments = repository.getEnrollmentsByStudent(studentId).stream()
                .filter(e -> e.getStatus().equals("ACTIVE"))
                .collect(Collectors.toList());

        int currentCredits = 0;
        for (Enrollment e : activeEnrollments) {
            Optional<Course> c = courseManager.getCourseByCode(e.getCourseCode());
            if (c.isPresent()) {
                currentCredits += c.get().getCredits();
            }
        }

        return (currentCredits + additionalCredits) <= 18;
    }

    @Override
    public List<Enrollment> getStudentEnrollments(String studentId) {
        return repository.getEnrollmentsByStudent(studentId);
    }

    @Override
    public List<Enrollment> getCourseEnrollments(String courseCode) {
        return repository.getEnrollmentsByCourse(courseCode);
    }
}
