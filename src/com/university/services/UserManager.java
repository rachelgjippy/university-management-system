package com.university.services;

import com.university.models.User;
import com.university.models.Student;
import com.university.models.Instructor;
import com.university.models.Admin;
import com.university.repositories.DataRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Manages user-related operations.
 */
public class UserManager {
    private DataRepository repository;

    public UserManager(DataRepository repository) {
        this.repository = repository;
    }

    public void registerStudent(String username, String password, String email, String fullName,
            String studentId, String program, int year) {
        String userId = "U" + System.currentTimeMillis(); // Simple ID generation
        Student student = new Student(userId, username, password, email, fullName, studentId, program, year);
        repository.saveUser(student);
    }

    public void registerInstructor(String username, String password, String email, String fullName,
            String instructorId, String department, String officeHours) {
        String userId = "U" + System.currentTimeMillis();
        Instructor instructor = new Instructor(userId, username, password, email, fullName, instructorId, department,
                officeHours);
        repository.saveUser(instructor);
    }

    public void registerAdmin(String username, String password, String email, String fullName,
            String adminId, String department) {
        String userId = "U" + System.currentTimeMillis();
        Admin admin = new Admin(userId, username, password, email, fullName, adminId, department);
        repository.saveUser(admin);
    }

    public Optional<User> getUser(String username) {
        return repository.getAllUsers().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public Optional<User> getUserById(String userId) {
        return Optional.ofNullable(repository.getUserById(userId));
    }

    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }
}
