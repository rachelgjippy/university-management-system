package com.university.services;

import com.university.models.Course;
import com.university.repositories.DataRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.ArrayList;

/**
 * Manages course-related operations.
 */
public class CourseManager {
    private DataRepository repository;

    public CourseManager(DataRepository repository) {
        this.repository = repository;
    }

    public void createCourse(String courseCode, String title, int credits, String instructorId, int capacity) {
        Course course = new Course(courseCode, title, credits, instructorId, capacity);
        repository.saveCourse(course);
    }

    public void updateCourse(Course course) {
        repository.updateCourse(course);
    }

    public void deleteCourse(String courseCode) {
        repository.deleteCourse(courseCode);
    }

    public Optional<Course> getCourseByCode(String courseCode) {
        return Optional.ofNullable(repository.getCourseByCode(courseCode));
    }

    public List<Course> getAllCourses() {
        return repository.getAllCourses();
    }

    public List<Course> getCoursesByDepartment(String department) {

        return repository.getAllCourses().stream()
                .filter(c -> c.getCourseCode().startsWith(department))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByInstructor(String instructorId) {
        return repository.getAllCourses().stream()
                .filter(c -> c.getInstructorId().equals(instructorId))
                .collect(Collectors.toList());
    }
}
