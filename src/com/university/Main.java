package com.university;

import com.university.auth.AuthenticationService;
import com.university.models.*;
import com.university.repositories.DataRepository;
import com.university.repositories.FileRepository;
import com.university.services.*;
import com.university.notifications.*;
import com.university.reports.*;

import java.util.Scanner;
import java.util.List;
import java.util.Optional;

/**
 * Main entry point for the University Management System.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Core Services
    private static DataRepository dataRepository;
    private static UserManager userManager;
    private static CourseManager courseManager;
    private static EnrollmentManager enrollmentManager;
    private static GradeManager gradeManager;
    private static NotificationManager notificationManager;
    private static AuthenticationService authService;
    private static ReportManager reportManager;

    public static void main(String[] args) {
        initializeSystem();
        seedData(); // Create default admin/users if empty

        System.out.println("========================================");
        System.out.println("University Course Management System");
        System.out.println("========================================\n");
boolean running = true;
while (running) {
    if (!authService.isLoggedIn()) {
        showLoginMenu();
    } else {
        // >>> INSERT HERE <<<
        if (authService.getCurrentSession() != null && !authService.getCurrentSession().isActive()) {
            System.out.println("Session expired. Please log in again.");
            authService.logout();
            continue;
        }
        // <<< END INSERT >>>

        String role = authService.getCurrentUser().getRole();
        switch (role) {
            case "ADMIN":
                showAdminMenu();
                break;
            case "INSTRUCTOR":
                showInstructorMenu();
                break;
            case "STUDENT":
                showStudentMenu();
                break;
            default:
                System.out.println("Unknown role. Logging out.");
                authService.logout();
        }
    }
}


        scanner.close();
    }

    // --- Initialization ---
    private static void initializeSystem() {
        dataRepository = new FileRepository();
        dataRepository.loadAllData(); // Load existing data if any

        courseManager = new CourseManager(dataRepository);
        userManager = new UserManager(dataRepository);
        enrollmentManager = new EnrollmentManager(dataRepository, courseManager, userManager);
        notificationManager = new NotificationManager();
        gradeManager = new GradeManager(dataRepository, notificationManager, userManager);
        authService = new AuthenticationService(userManager);
        reportManager = new ReportManager(userManager, courseManager, gradeManager, enrollmentManager);
    }

    private static void seedData() {
        // Create default admin if no users exist
        if (userManager.getAllUsers().isEmpty()) {
            System.out.println("Seeding default data...");
            userManager.registerAdmin("admin", "admin123", "admin@university.com", "System Admin", "ADM001", "IT");
            userManager.registerInstructor("prof1", "prof123", "prof1@university.com", "John Doe", "INS001", "CS",
                    "Mon 10-12");
            userManager.registerStudent("student1", "student123", "student1@university.com", "Alice Smith", "STU001",
                    "CS", 1);

            // Seed a course
            courseManager.createCourse("CS101", "Intro to Programming", 3, "INS001", 30);
        }
    }

    // --- Menus ---

    private static void showLoginMenu() {
        System.out.println("\n=== Login Menu ===");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                performLogin();
                break;
            case 2:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void performLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authService.login(username, password);
        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getFullName());
        } else {
            System.out.println("Invalid credentials.");
        }
    }

  private static void showAdminMenu() {
    System.out.println("\n=== Admin Menu ===");
    System.out.println("1. Manage Users (List All)");
    System.out.println("2. Create New User");
    System.out.println("3. Manage Courses (List All)");
    System.out.println("4. Create New Course");
    System.out.println("5. View All Enrollments"); // Simplified
    System.out.println("6. Logout");
    System.out.print("Choose an option: ");

    int choice = getIntInput();

    switch (choice) {
        case 1:
            // TODO: Implement user listing logic
            if (!authService.canPerformAction("MANAGE_USERS")) {
                System.out.println("Access denied.");
                break;
            }
            listAllUsers();
            break;

        case 2:
            // TODO: Implement user creation logic
            if (!authService.canPerformAction("MANAGE_USERS")) {
                System.out.println("Access denied.");
                break;
            }
            createNewUser();
            break;

        case 3:
            // TODO: Implement course listing logic
            if (!authService.canPerformAction("MANAGE_COURSES")) {
                System.out.println("Access denied.");
                break;
            }
            listAllCourses();
            break;

        case 4:
            // TODO: Implement course creation logic
            if (!authService.canPerformAction("MANAGE_COURSES")) {
                System.out.println("Access denied.");
                break;
            }
            createNewCourse();
            break;

        case 5:
            // TODO: Implement enrollment viewing logic
            if (!authService.canPerformAction("MANAGE_USERS")) {
                System.out.println("Access denied.");
                break;
            }
            System.out.println("Feature not implemented in menu yet.");
            break;

        case 6:
            authService.logout();
            System.out.println("Logged out successfully.");
            break;

        default:
            System.out.println("Invalid option.");
    }
}


    private static void showInstructorMenu() {
    Instructor instructor = (Instructor) authService.getCurrentUser();
    System.out.println("\n=== Instructor Menu (" + instructor.getFullName() + ") ===");
    System.out.println("1. View My Courses");
    System.out.println("2. View Course Roster");
    System.out.println("3. Assign Grades");
    System.out.println("4. Generate Teaching Load Report");
    System.out.println("5. Logout");
    System.out.print("Choose an option: ");

    int choice = getIntInput();

    switch (choice) {
        case 1:
            // TODO: Implement instructor course listing logic
            if (!authService.canPerformAction("MANAGE_COURSES")) {
                System.out.println("Access denied.");
                break;
            }
            listInstructorCourses(instructor.getInstructorId());
            break;

        case 2:
            // TODO: Implement course roster viewing logic
            if (!authService.canPerformAction("GENERATE_REPORTS")) {
                System.out.println("Access denied.");
                break;
            }
            viewCourseRoster();
            break;

        case 3:
            // TODO: Implement grade assignment logic
            if (!authService.canPerformAction("ASSIGN_GRADE")) {
                System.out.println("Access denied.");
                break;
            }
            assignGrades();
            break;

        case 4:
            // TODO: Implement teaching load report logic
            if (!authService.canPerformAction("GENERATE_REPORTS")) {
                System.out.println("Access denied.");
                break;
            }
            Report report = reportManager.generateTeachingLoad(instructor.getInstructorId());
            if (report != null)
                System.out.println(report.generateReport());
            break;

        case 5:
            authService.logout();
            break;

        default:
            System.out.println("Invalid option.");
    }
}

    private static void showStudentMenu() {
    Student student = (Student) authService.getCurrentUser();
    System.out.println("\n=== Student Menu (" + student.getFullName() + ") ===");
    System.out.println("1. View Available Courses");
    System.out.println("2. Enroll in Course");
    System.out.println("3. Drop Course");
    System.out.println("4. View My Enrollments");
    System.out.println("5. View My Grades");
    System.out.println("6. Generate Transcript");
    System.out.println("7. Logout");
    System.out.print("Choose an option: ");

    int choice = getIntInput();

    switch (choice) {
        case 1:
            // TODO: Implement course listing logic
            listAllCourses();
            break;

        case 2:
            // TODO: Implement enrollment logic
            if (!authService.canPerformAction("ENROLL_STUDENT")) {
                System.out.println("Access denied.");
                break;
            }
            enrollInCourse(student);
            break;

        case 3:
            // TODO: Implement drop course logic
            if (!authService.canPerformAction("DROP_COURSE")) {
                System.out.println("Access denied.");
                break;
            }
            dropCourse(student);
            break;

        case 4:
            // TODO: Implement enrollment viewing logic
            listStudentEnrollments(student.getStudentId());
            break;

        case 5:
            // TODO: Implement grade viewing logic
            List<Grade> grades = gradeManager.getStudentGrades(student.getStudentId());
            if (grades.isEmpty())
                System.out.println("No grades found.");
            else
                grades.forEach(System.out::println);
            break;

        case 6:
            // TODO: Implement transcript generation logic
            if (!authService.canPerformAction("VIEW_TRANSCRIPT")) {
                System.out.println("Access denied.");
                break;
            }
            Report report = reportManager.generateTranscript(student.getStudentId());
            if (report != null)
                System.out.println(report.generateReport());
            break;

        case 7:
            authService.logout();
            break;

        default:
            System.out.println("Invalid option.");
    }
}

    // --- Helper Methods ---

    private static void listAllUsers() {
        List<User> users = userManager.getAllUsers();
        if (users.isEmpty())
            System.out.println("No users found.");
        else
            users.forEach(User::displayInfo);
    }

    private static void createNewUser() {
        System.out.println("Select type: 1. Student 2. Instructor 3. Admin");
        int type = getIntInput();

        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Full Name: ");
        String name = scanner.nextLine();

        if (type == 1) {
            System.out.print("Student ID: ");
            String sid = scanner.nextLine();
            System.out.print("Program: ");
            String prog = scanner.nextLine();
            System.out.print("Year: ");
            int year = getIntInput();
            userManager.registerStudent(user, pass, email, name, sid, prog, year);
        } else if (type == 2) {
            System.out.print("Instructor ID: ");
            String iid = scanner.nextLine();
            System.out.print("Department: ");
            String dept = scanner.nextLine();
            System.out.print("Office Hours: ");
            String hours = scanner.nextLine();
            userManager.registerInstructor(user, pass, email, name, iid, dept, hours);
        } else if (type == 3) {
            System.out.print("Admin ID: ");
            String aid = scanner.nextLine();
            System.out.print("Department: ");
            String dept = scanner.nextLine();
            userManager.registerAdmin(user, pass, email, name, aid, dept);
        } else {
            System.out.println("Invalid type.");
        }
        System.out.println("User created.");
    }

    private static void listAllCourses() {
        List<Course> courses = courseManager.getAllCourses();
        if (courses.isEmpty())
            System.out.println("No courses found.");
        else
            courses.forEach(System.out::println);
    }

    private static void createNewCourse() {
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Credits: ");
        int credits = getIntInput();
        System.out.print("Instructor ID: ");
        String insId = scanner.nextLine();
        System.out.print("Capacity: ");
        int cap = getIntInput();

        courseManager.createCourse(code, title, credits, insId, cap);
        System.out.println("Course created.");
    }

    private static void listInstructorCourses(String instructorId) {
        List<Course> courses = courseManager.getCoursesByInstructor(instructorId);
        if (courses.isEmpty())
            System.out.println("No courses relevant to you.");
        else
            courses.forEach(System.out::println);
    }

    private static void viewCourseRoster() {
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();
        Report report = reportManager.generateCourseRoster(code);
        if (report != null)
            System.out.println(report.generateReport());
        else
            System.out.println("Could not generate roster (Course not found?).");
    }

    private static void assignGrades() {
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Student ID: ");
        String sid = scanner.nextLine();
        System.out.print("Score (0.0-100.0): ");
        double score = -1;
        try {
            score = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
        }

        System.out.print("Grading Type (LETTER/PASS_FAIL/NUMERIC): ");
        String type = scanner.nextLine();
        if (type.isEmpty())
            type = "LETTER";

        boolean success = gradeManager.assignGrade(sid, code, score, type, "Current");
        if (success)
            System.out.println("Grade assigned.");
        else
            System.out.println("Failed to assign grade.");
    }

    private static void enrollInCourse(Student student) {
        System.out.print("Enter Course Code to Enroll: ");
        String code = scanner.nextLine();
        enrollmentManager.enrollStudent(student.getStudentId(), code, "Current");
    }

    private static void dropCourse(Student student) {
        System.out.print("Enter Course Code to Drop: ");
        String code = scanner.nextLine();
        if (enrollmentManager.dropCourse(student.getStudentId(), code)) {
            System.out.println("Course dropped.");
        } else {
            System.out.println("Failed to drop course.");
        }
    }

    private static void listStudentEnrollments(String studentId) {
        List<Enrollment> enrollments = enrollmentManager.getStudentEnrollments(studentId);
        if (enrollments.isEmpty())
            System.out.println("No enrollments found.");
        else
            enrollments.forEach(System.out::println);
    }

    /**
     * Helper method to get integer input with error handling.
     */
    private static int getIntInput() {
        try {
            int value = Integer.parseInt(scanner.nextLine());
            return value;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
