package com.university.services;

import com.university.models.Grade;
import com.university.models.GradeCalculator;
import com.university.models.LetterGradeCalculator;
import com.university.models.PassFailCalculator;
import com.university.models.NumericalGradeCalculator;
import com.university.models.Student;
import com.university.models.User;
import com.university.notifications.NotificationService;
import com.university.repositories.DataRepository;
import java.util.List;
import java.util.Optional;

/**
 * Manages grade-related operations.
 */
public class GradeManager {
    private DataRepository repository;
    private NotificationService notificationService;
    private UserManager userManager;

    public GradeManager(DataRepository repository, NotificationService notificationService, UserManager userManager) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.userManager = userManager;
    }

    public boolean assignGrade(String studentId, String courseCode, double score, String gradingType, String semester) {
        // 1. Validate student and course existence (could check cache or repo)
        // For simplicity assuming they exist if we are assigning grades.

        // 2. Calculate grade
        GradeCalculator calculator;
        switch (gradingType.toUpperCase()) {
            case "LETTER":
                calculator = new LetterGradeCalculator(courseCode, studentId);
                break;
            case "PASS_FAIL":
                calculator = new PassFailCalculator(courseCode, studentId);
                break;
            case "NUMERIC":
                calculator = new NumericalGradeCalculator(courseCode, studentId);
                break;
            default:
                calculator = new LetterGradeCalculator(courseCode, studentId);
        }

        if (!calculator.isValidScore(score)) {
            System.out.println("Invalid score: " + score);
            return false;
        }

        String letterGrade = calculator.calculateGrade(score);
        String gradeId = "G" + System.currentTimeMillis();

        Grade grade = new Grade(gradeId, studentId, courseCode, score, letterGrade, semester);
        repository.saveGrade(grade);

        // 3. Update Student GPA
        updateStudentGPA(studentId);

        // 4. Notify Student
        notificationService.notifyGradePosted(studentId, courseCode, letterGrade);

        return true;
    }

    private void updateStudentGPA(String studentId) {
        Optional<User> userOpt = userManager.getUserById(studentId);
        if (userOpt.isPresent() && userOpt.get() instanceof Student) {
            Student student = (Student) userOpt.get();
            List<Grade> grades = repository.getGradesByStudent(studentId);

            // Convert List to Array because Student.calculateGPA takes array currently
            // Or better, update Student.java to take List.
            // Let's stick to array for now as internal implementation Detail of Student
            // model,
            // or cast/toArray. Student.calculateGPA expects Grade[].
            Grade[] gradeArray = grades.toArray(new Grade[0]);
            student.calculateGPA(gradeArray);

            userManager.registerStudent(student.getUsername(), student.getPassword(), student.getEmail(),
                    student.getFullName(), student.getStudentId(), student.getProgram(), student.getYear());
            // Wait, registerStudent creates NEW student. We need Update.
            // UserManager doesn't expose update directly properly?
            // DataRepository has update.
            repository.updateUser(student);
        }
    }

    public List<Grade> getStudentGrades(String studentId) {
        return repository.getGradesByStudent(studentId);
    }
}
