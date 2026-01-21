# Project Tasks Checklist

Use this file to track your team's progress. Mark tasks as complete with [x].

## Component 1: User Management (Students 1-2)
**Assigned to:** [Student 1 Name] & [Student 2 Name]

- [ ] Create Student.java class
  - [ ] Add fields: studentId, program, year, gpa, completedCourses
  - [ ] Implement displayInfo() method
  - [ ] Implement getRole() method
  - [ ] Add methods: calculateGPA(), addCompletedCourse()
  
- [ ] Create Instructor.java class
  - [ ] Add fields: instructorId, department, officeHours, coursesTaught
  - [ ] Implement displayInfo() method
  - [ ] Implement getRole() method
  - [ ] Add methods: addCourse(), removeCourse()
  
- [ ] Create Admin.java class
  - [ ] Add fields: adminId, department, permissions
  - [ ] Implement displayInfo() method
  - [ ] Implement getRole() method
  
- [ ] Create UserManager.java class
  - [ ] Implement createUser()
  - [ ] Implement updateUser()
  - [ ] Implement deleteUser()
  - [ ] Implement getUserById()
  - [ ] Implement getAllUsers()

---

## Component 2: Course Management (Student 3)
**Assigned to:** [Student 3 Name]

- [ ] Enhance Course.java class
  - [ ] Add validation for credits (must be positive)
  - [ ] Add validation for capacity (must be positive)
  - [ ] Test isFull() method
  - [ ] Test addStudent() method
  - [ ] Test removeStudent() method
  
- [ ] Create CourseManager.java class
  - [ ] Implement createCourse()
  - [ ] Implement updateCourse()
  - [ ] Implement deleteCourse()
  - [ ] Implement getCourseByCode()
  - [ ] Implement getAllCourses()
  - [ ] Implement filterCoursesByDepartment()
  - [ ] Implement filterCoursesByInstructor()

---

## Component 3: Enrollment System (Student 4)
**Assigned to:** [Student 4 Name]

- [ ] Create EnrollmentManager.java (implements EnrollmentService)
  - [ ] Implement enrollStudent()
    - [ ] Check if course is full
    - [ ] Check prerequisites
    - [ ] Check credit limit (max 18 credits per semester)
    - [ ] Create enrollment record
    - [ ] Update course enrollment list
    - [ ] Send notification
  - [ ] Implement dropCourse()
    - [ ] Update enrollment status to "DROPPED"
    - [ ] Remove student from course list
    - [ ] Send notification
  - [ ] Implement checkPrerequisites()
  - [ ] Implement checkCreditLimit()
  - [ ] Implement getStudentEnrollments()
  - [ ] Implement getCourseEnrollments()

---

## Component 4: Grade Management (Student 5)
**Assigned to:** [Student 5 Name]

- [ ] Create LetterGradeCalculator.java (extends GradeCalculator)
  - [ ] Implement calculateGrade() (90-100: A, 80-89: B, etc.)
  - [ ] Implement calculateGPA() (A: 4.0, B: 3.0, etc.)
  - [ ] Implement isValidScore()
  
- [ ] Create PassFailCalculator.java (extends GradeCalculator)
  - [ ] Implement calculateGrade() (>=60: Pass, <60: Fail)
  - [ ] Implement calculateGPA() (Pass: credit earned, Fail: 0)
  - [ ] Implement isValidScore()
  
- [ ] Create NumericalGradeCalculator.java (extends GradeCalculator)
  - [ ] Implement calculateGrade() (return raw score)
  - [ ] Implement calculateGPA() (convert to 4.0 scale)
  - [ ] Implement isValidScore()
  
- [ ] Create GradeManager.java
  - [ ] Implement assignGrade()
  - [ ] Implement updateGrade()
  - [ ] Implement calculateStudentGPA()
  - [ ] Implement getStudentGrades()
  - [ ] Implement getCourseGrades()
  - [ ] Integrate with NotificationService

---

## Component 5: Notification System (Student 6)
**Assigned to:** [Student 6 Name]

- [ ] Create EmailNotification.java (extends Notification)
  - [ ] Implement send() method (simulate sending)
  - [ ] Implement getNotificationType()
  - [ ] Implement formatMessage()
  
- [ ] Create SMSNotification.java (extends Notification)
  - [ ] Implement send() method
  - [ ] Implement getNotificationType()
  - [ ] Implement formatMessage()
  
- [ ] Create InAppNotification.java (extends Notification)
  - [ ] Implement send() method
  - [ ] Implement getNotificationType()
  - [ ] Implement formatMessage()
  
- [ ] Create NotificationManager.java (implements NotificationService)
  - [ ] Implement sendNotification()
  - [ ] Implement notifyEnrollment()
  - [ ] Implement notifyGradePosted()
  - [ ] Implement notifyCourseDropped()
  - [ ] Implement sendAnnouncement()

---

## Component 6: Reporting System (Student 7)
**Assigned to:** [Student 7 Name]

- [ ] Create Transcript.java (extends Report)
  - [ ] Implement generateReport() (show student's courses and grades)
  - [ ] Implement getReportType()
  - [ ] Implement validate()
  - [ ] Format with headers and GPA calculation
  
- [ ] Create CourseRoster.java (extends Report)
  - [ ] Implement generateReport() (list all enrolled students)
  - [ ] Implement getReportType()
  - [ ] Implement validate()
  
- [ ] Create TeachingLoad.java (extends Report)
  - [ ] Implement generateReport() (list instructor's courses)
  - [ ] Implement getReportType()
  - [ ] Implement validate()
  
- [ ] Create DepartmentSummary.java (extends Report)
  - [ ] Implement generateReport() (department statistics)
  - [ ] Implement getReportType()
  - [ ] Implement validate()
  
- [ ] Create ReportManager.java (implements ReportGenerator)
  - [ ] Implement generateTranscript()
  - [ ] Implement generateCourseRoster()
  - [ ] Implement generateTeachingLoad()
  - [ ] Implement generateDepartmentSummary()
  - [ ] Implement saveReport()

---

## Component 7: Authentication & Authorization (Student 8)
**Assigned to:** [Student 8 Name]

- [ ] Complete AuthenticationService.java
  - [ ] Implement login() with password validation
  - [ ] Test hasRole() method
  - [ ] Test canPerformAction() method
  - [ ] Add more action types as needed
  
- [ ] Create Session.java (optional)
  - [ ] Track login time
  - [ ] Track session duration
  - [ ] Implement timeout functionality
  
- [ ] Create AccessControl.java
  - [ ] Define permissions for each role
  - [ ] Implement permission checking

---

## Component 8: Data Persistence (Student 8)
**Assigned to:** [Student 8 Name]

- [ ] Create FileRepository.java (implements DataRepository)
  - [ ] Implement saveUser() / getUserById() / getAllUsers()
  - [ ] Implement saveCourse() / getCourseByCode() / getAllCourses()
  - [ ] Implement saveEnrollment() / getEnrollmentsByStudent()
  - [ ] Implement saveGrade() / getGradesByStudent()
  - [ ] Implement loadAllData() (load from files on startup)
  - [ ] Implement saveAllData() (save to files periodically)
  - [ ] Handle FileNotFoundException
  - [ ] Handle IOException

---

## Integration Tasks (All Students)

- [ ] Integrate UserManager with FileRepository
- [ ] Integrate CourseManager with FileRepository
- [ ] Integrate EnrollmentManager with CourseManager
- [ ] Integrate EnrollmentManager with NotificationManager
- [ ] Integrate GradeManager with NotificationManager
- [ ] Integrate ReportManager with all other managers
- [ ] Integrate AuthenticationService with UserManager
- [ ] Complete Main.java menu system
  - [ ] Implement login functionality
  - [ ] Implement admin menu options
  - [ ] Implement instructor menu options
  - [ ] Implement student menu options

---

## Testing Tasks (All Students)

- [ ] Test user creation and retrieval
- [ ] Test course creation and capacity checking
- [ ] Test enrollment with prerequisite validation
- [ ] Test enrollment with credit limit validation
- [ ] Test grade assignment and GPA calculation
- [ ] Test all notification types
- [ ] Test all report types
- [ ] Test authentication and authorization
- [ ] Test data persistence (save and load)
- [ ] Test complete enrollment workflow
- [ ] Test complete grading workflow

---

## Documentation Tasks (All Students)

- [ ] Update README with team member names
- [ ] Document design decisions in README
- [ ] Document OOP concepts demonstrated
- [ ] Add code comments to complex methods
- [ ] Create sample usage section
- [ ] List known limitations
- [ ] List future enhancements

---

## Git Tasks (All Students)

- [ ] Each student creates at least 3 meaningful commits
- [ ] All commits have descriptive messages
- [ ] No merge conflicts
- [ ] Repository is public/accessible
- [ ] .gitignore is working correctly (no .class files committed)

---

## Submission Tasks (Team Lead)

- [ ] All code compiles without errors
- [ ] Application runs successfully
- [ ] README is complete
- [ ] Repository URL submitted to Google Form
- [ ] Submission done before Monday 11:59 PM

---

## Notes Section

Add any important notes, decisions, or issues here:

```
[Date] - [Your Name]: Decided to use text files for data storage instead of serialization
[Date] - [Your Name]: Changed maximum credit limit from 20 to 18 credits
[Date] - [Your Name]: Fixed bug in enrollment validation
```

---

**Remember:** Update this file regularly and communicate with your team!
