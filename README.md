# University Course Management System

## Project Overview
A console-based Java application for managing university courses, users, enrollments, and grades. This project demonstrates core Object-Oriented Programming (OOP) principles: **Inheritance**, **Polymorphism**, **Encapsulation**, and **Abstraction**.

---

## Team Information
**Group Members:**
1. [Student 1 Name] - User Management (Component 1)
2. [Rachel Gifty Jippy] - User Management (Component 1)
3. [Student 3 Name] - Course Management (Component 2)
4. [Student 4 Name] - Enrollment System (Component 3)
5. [Mohammed Rida /25398/2024] - Grade Management (Component 4)
6. [Ammar babeker 29553/2025] - Notification System (Component 5)
7. [Student 7 Name] - Reporting System (Component 6)
8. [Student 8 Name] - Authentication & Data Persistence (Components 7 & 8)

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Git
- A text editor or IDE (VS Code, IntelliJ IDEA, Eclipse, or NetBeans)

### How to Clone and Run

1. **Clone the repository:**
   ```bash
   git clone [YOUR_REPOSITORY_URL]
   cd university-management-system
   ```

2. **Compile the project:**
   ```bash
   javac -d bin src/com/university/**/*.java src/com/university/*.java
   ```

3. **Run the application:**
   ```bash
   java -cp bin com.university.Main
   ```

### Sample Credentials (After Implementation)
- **Admin:** username: `admin`, password: `admin123`
- **Instructor:** username: `prof1`, password: `prof123`
- **Student:** username: `student1`, password: `student123`

---

## Component Responsibilities

### Component 1: User Management (Students 1-2)
**Classes to Implement:**
- `Student.java` (extends User)
- `Instructor.java` (extends User)
- `Admin.java` (extends User)
- `UserManager.java` (manages CRUD operations)

**Key Tasks:**
- Implement Student class with: studentId, program, year, GPA, completedCourses
- Implement Instructor class with: instructorId, department, officeHours, coursesTaught
- Implement Admin class with: adminId, department, permissions
- Override `displayInfo()` method in each subclass (polymorphism)
- Override `getRole()` method to return appropriate role string

**OOP Concepts:** Inheritance, Polymorphism

---

### Component 2: Course Management (Student 3)
**Classes to Implement:**
- `CourseManager.java`
- Enhance `Course.java` with validation methods

**Key Tasks:**
- Implement course creation, update, deletion
- Validate course data (credits > 0, valid instructor, etc.)
- Implement prerequisite checking logic
- Create methods to filter courses by department/instructor

**OOP Concepts:** Encapsulation

---

### Component 3: Enrollment System (Student 4)
**Classes to Implement:**
- `EnrollmentManager.java` (implements EnrollmentService)

**Key Tasks:**
- Implement `enrollStudent()` with validation:
  - Course not full
  - Prerequisites met
  - No time conflicts (if implementing schedules)
  - Credit limit not exceeded (e.g., max 18 credits)
- Implement `dropCourse()`
- Track enrollment status (ACTIVE, DROPPED, COMPLETED)
- Integrate with NotificationService to send enrollment confirmations

**OOP Concepts:** Abstraction (implementing interface)

---

### Component 4: Grade Management (Student 5)
**Classes to Implement:**
- `LetterGradeCalculator.java` (extends GradeCalculator)
- `PassFailCalculator.java` (extends GradeCalculator)
- `NumericalGradeCalculator.java` (extends GradeCalculator)
- `GradeManager.java`

**Key Tasks:**
- Implement LetterGradeCalculator:
  - 90-100: A (4.0), 80-89: B (3.0), 70-79: C (2.0), 60-69: D (1.0), <60: F (0.0)
- Implement PassFailCalculator:
  - >= 60: Pass (credit earned), < 60: Fail (no credit)
- Implement NumericalGradeCalculator:
  - Store raw score (0-100)
- Create GradeManager to assign grades and calculate student GPA
- Integrate with NotificationService to notify students of new grades

**OOP Concepts:** Inheritance, Polymorphism

---

### Component 5: Notification System (Student 6)
**Classes to Implement:**
- `EmailNotification.java` (extends Notification)
- `SMSNotification.java` (extends Notification)
- `InAppNotification.java` (extends Notification)
- `NotificationManager.java` (implements NotificationService)

**Key Tasks:**
- Implement each notification type's `send()` method (simulate sending)
- Implement `formatMessage()` for each type
- Create NotificationManager to handle notification triggers:
  - Enrollment confirmation
  - Grade posted
  - Course dropped
  - Administrative announcements
- Use polymorphism to send different notification types

**OOP Concepts:** Abstraction, Polymorphism

---

### Component 6: Reporting System (Student 7)
**Classes to Implement:**
- `Transcript.java` (extends Report)
- `CourseRoster.java` (extends Report)
- `TeachingLoad.java` (extends Report)
- `DepartmentSummary.java` (extends Report)
- `ReportManager.java` (implements ReportGenerator)

**Key Tasks:**
- Implement Transcript: Show student's completed courses and grades
- Implement CourseRoster: Show all students enrolled in a course
- Implement TeachingLoad: Show all courses taught by an instructor
- Implement DepartmentSummary: Show statistics for a department
- Each report should have proper formatting and validation

**OOP Concepts:** Inheritance

---

### Component 7: Authentication & Authorization (Student 8)
**Classes to Implement:**
- Complete `AuthenticationService.java`
- `Session.java`
- `AccessControl.java`

**Key Tasks:**
- Implement login with username/password validation
- Implement role-based access control:
  - Students: enroll, drop, view own grades
  - Instructors: manage courses, assign grades
  - Admins: full system access
- Create session management (track current user)
- Hash passwords (bonus: use simple encryption)

**OOP Concepts:** Encapsulation

---

### Component 8: Data Persistence (Student 8)
**Classes to Implement:**
- `FileRepository.java` (implements DataRepository)

**Key Tasks:**
- Implement file-based storage (use text files or Java serialization)
- Create separate files for users, courses, enrollments, grades
- Implement save/load operations for each entity type
- Handle file I/O exceptions gracefully
- Store files in `data/` directory

**OOP Concepts:** Abstraction (implementing interface)

---

## Integration Guidelines

### How Components Work Together

1. **Main → AuthenticationService**: Handle login
2. **AuthenticationService → UserManager**: Retrieve user data
3. **Main → EnrollmentManager**: Student enrolls in course
4. **EnrollmentManager → CourseManager**: Check course availability
5. **EnrollmentManager → GradeManager**: Check prerequisites (past grades)
6. **EnrollmentManager → NotificationManager**: Send enrollment confirmation
7. **GradeManager → NotificationManager**: Notify grade posted
8. **ReportManager → All Managers**: Gather data for reports
9. **FileRepository → All Managers**: Load/save data

### Coordination Tips
- Use a **shared Google Doc** to track interface contracts
- **Meet regularly** to discuss integration points
- **Test components individually** before integration
- **Use Git branches** for features, merge to main when stable
- **Communicate via WhatsApp/Slack** for quick questions

---

## Implementation Timeline

### Day 1 (Friday)
- Set up Git repository
- Each student creates their assigned classes
- Implement basic structure (constructors, getters/setters)

### Day 2 (Saturday)
- Implement core business logic for each component
- Start integration between related components
- Test individual components

### Day 3 (Sunday)
- Complete all components
- Integrate all components in Main.java
- Implement menu system
- Test full workflows

### Day 4 (Monday)
- Bug fixes and refinements
- Complete README documentation
- Prepare sample data for demonstration
- Final testing

---

## Testing Your Code

### Unit Testing (Manual)
Test each component individually before integration:

**Example: Testing Course Management**
```java
// Create a course
Course course = new Course("CS101", "Intro to Programming", 3, "prof1", 30);

// Test capacity check
System.out.println(course.isFull()); // Should print false

// Test adding students
for (int i = 0; i < 30; i++) {
    course.addStudent("student" + i);
}
System.out.println(course.isFull()); // Should print true
```

### Integration Testing
Test component interactions:

**Example: Enrollment Workflow**
```java
// 1. Student logs in
// 2. Views available courses
// 3. Enrolls in a course
// 4. Receives notification
// 5. Views updated enrollment list
```

---

## OOP Concepts Demonstrated

### 1. Inheritance
**Definition:** A mechanism where a new class inherits properties and behaviors from an existing class.

**Examples in Our Project:**
- `Student`, `Instructor`, `Admin` extend `User`
- `LetterGradeCalculator`, `PassFailCalculator` extend `GradeCalculator`
- `Transcript`, `CourseRoster` extend `Report`
- `EmailNotification`, `SMSNotification` extend `Notification`

**Code Example:**
```java
public class Student extends User {
    private double gpa;
    
    @Override
    public void displayInfo() {
        System.out.println("Student: " + getFullName());
        System.out.println("GPA: " + gpa);
    }
    
    @Override
    public String getRole() {
        return "STUDENT";
    }
}
```

---

### 2. Polymorphism
**Definition:** The ability of objects to take multiple forms. Same method name, different implementations.

**Examples in Our Project:**
- `displayInfo()` method behaves differently for Student, Instructor, Admin
- `send()` method works differently for Email, SMS, InApp notifications
- `calculateGrade()` varies by grading scheme

**Code Example:**
```java
User user1 = new Student(...);
User user2 = new Instructor(...);

user1.displayInfo(); // Calls Student's version
user2.displayInfo(); // Calls Instructor's version
```

---

### 3. Encapsulation
**Definition:** Bundling data and methods that operate on that data within a class, hiding internal details.

**Examples in Our Project:**
- All fields are `private` with `public` getters/setters
- Validation logic is hidden inside methods
- Course capacity checking is encapsulated in `isFull()` method

**Code Example:**
```java
public class Course {
    private int capacity; // Hidden from outside
    
    public void setCapacity(int capacity) {
        if (capacity > 0) { // Validation hidden here
            this.capacity = capacity;
        }
    }
    
    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }
}
```

---

### 4. Abstraction
**Definition:** Hiding complex implementation details and showing only essential features.

**Examples in Our Project:**
- `EnrollmentService` interface hides enrollment complexity
- `DataRepository` interface hides storage mechanism
- Abstract classes (`User`, `Notification`, `Report`) define structure without implementation

**Code Example:**
```java
// Interface defines WHAT to do, not HOW
public interface EnrollmentService {
    Enrollment enrollStudent(String studentId, String courseCode, String semester);
}

// Implementation defines HOW
public class EnrollmentManager implements EnrollmentService {
    @Override
    public Enrollment enrollStudent(String studentId, String courseCode, String semester) {
        // Complex logic here
        // Check prerequisites, capacity, conflicts, etc.
    }
}
```

---

## Features Implemented

- [ ] User Management (Create, Read, Update, Delete users)
- [ ] Course Management (Create, Read, Update, Delete courses)
- [ ] Enrollment System (Enroll, Drop with validations)
- [ ] Grade Management (Multiple grading schemes)
- [ ] Notification System (Email, SMS, In-App)
- [ ] Reporting System (Transcripts, Rosters, etc.)
- [ ] Authentication (Login/Logout)
- [ ] Authorization (Role-based access)
- [ ] Data Persistence (File-based storage)

---

## Known Limitations

[List any features not implemented or limitations of your system]

Example:
- No time conflict checking (courses don't have schedules yet)
- No real email sending (simulated only)
- No password encryption (stored in plain text)

---

## Future Enhancements

[List potential improvements]

Example:
- Add course scheduling with time slots
- Implement actual email integration
- Add course waitlist feature
- Create a web-based interface
- Add payment and billing module

---

## Design Decisions

### Why We Used Interfaces
We used interfaces (`EnrollmentService`, `DataRepository`, `NotificationService`) to:
- Allow multiple implementations (e.g., could switch from file storage to database)
- Make code more testable
- Follow the principle of "program to an interface, not an implementation"

### Why We Used Abstract Classes
We used abstract classes (`User`, `Notification`, `Report`) to:
- Share common code among subclasses
- Enforce certain methods must be implemented by subclasses
- Provide a common base for polymorphic operations

### Why We Separated Concerns
Each component handles a specific responsibility:
- Easier to maintain and debug
- Multiple students can work simultaneously
- Changes in one component don't break others

---

## Common Issues and Solutions

### Issue: "Cannot find symbol" error
**Solution:** Make sure all classes are in the correct package and imported properly.

### Issue: NullPointerException
**Solution:** Always check if objects are null before using them.
```java
if (user != null) {
    user.displayInfo();
}
```

### Issue: Git merge conflicts
**Solution:** 
1. Pull latest changes: `git pull origin main`
2. Resolve conflicts in your editor
3. Test that everything still works
4. Commit and push

---

## Sample Usage

### Example Workflow: Student Enrolling in a Course

1. **Admin creates a course:**
   ```
   Admin Login → Manage Courses → Create Course
   Course Code: CS101
   Title: Intro to Programming
   Credits: 3
   Capacity: 30
   ```

2. **Student enrolls:**
   ```
   Student Login → View Available Courses → Select CS101 → Enroll
   System checks: Prerequisites? Capacity? Credit limit?
   Enrollment successful!
   Notification sent: "You are now enrolled in CS101"
   ```

3. **Instructor assigns grade:**
   ```
   Instructor Login → View My Courses → CS101 → Assign Grades
   Select Student → Enter Score: 85
   Grade calculated: B (3.0 GPA)
   Notification sent: "Your grade for CS101 has been posted"
   ```

4. **Student views transcript:**
   ```
   Student Login → Generate Transcript
   Course: CS101 | Grade: B | Credits: 3 | GPA: 3.0
   Overall GPA: 3.0
   ```

---

## Collaboration Guidelines

### Git Workflow
1. **Create a feature branch:**
   ```bash
   git checkout -b feature/user-management
   ```

2. **Make your changes and commit:**
   ```bash
   git add .
   git commit -m "Implemented Student class with GPA calculation"
   ```

3. **Push your branch:**
   ```bash
   git push origin feature/user-management
   ```

4. **Create Pull Request (optional):**
   - Go to GitHub
   - Click "Compare & pull request"
   - Wait for team review

5. **Merge to main:**
   ```bash
   git checkout main
   git merge feature/user-management
   git push origin main
   ```

### Communication
- **Daily standups:** Brief 10-minute meetings to sync progress
- **Code reviews:** Review each other's code before merging
- **Shared document:** Track who's working on what to avoid conflicts

---

## Submission Checklist

Before submitting, make sure:
- [ ] All 8 components are implemented
- [ ] Code compiles without errors
- [ ] Basic functionality works (can login, enroll, assign grades, etc.)
- [ ] Each team member has at least 3 meaningful commits
- [ ] README is complete with team names
- [ ] .gitignore is properly configured
- [ ] No sensitive data (passwords, personal info) in repository
- [ ] Repository is public (or accessible to instructor)
- [ ] Google Form submitted with repository URL

---

## Resources

### Java Documentation
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)

### Git Resources
- [Git Basics](https://git-scm.com/book/en/v2/Getting-Started-Git-Basics)
- [Git Collaboration](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)

### OOP Resources
- [OOP in Java](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)
- [Java Inheritance](https://www.w3schools.com/java/java_inheritance.asp)

---

## Contact

For questions or issues, contact:
- **Instructor:** [juliuskanneh7@gmail.com]
- **Teaching Assistant:** [TA Email]

---

## License

This project is for educational purposes as part of the OOP with Java course.

---

**Good luck with your project! Remember: Communication and collaboration are key to success!**
