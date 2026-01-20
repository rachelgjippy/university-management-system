# Data Directory

This directory will store your application data files.

## Files to Create (by Component 8 - Data Persistence team):
- `users.txt` or `users.dat` - Store all user records
- `courses.txt` or `courses.dat` - Store all course records
- `enrollments.txt` or `enrollments.dat` - Store all enrollment records
- `grades.txt` or `grades.dat` - Store all grade records

## Note:
These files are gitignored (see .gitignore) so they won't be committed to the repository.
This is intentional - we don't want to commit user data to version control.

## Example Data Format (Text File Approach):

### users.txt
```
USER_ID|USERNAME|PASSWORD|EMAIL|FULL_NAME|ROLE|SPECIFIC_DATA
S001|student1|pass123|student1@university.edu|John Doe|STUDENT|CS|2024|3.5
I001|prof1|profpass|prof1@university.edu|Dr. Jane Smith|INSTRUCTOR|Computer Science|MWF 2-4PM
A001|admin|admin123|admin@university.edu|Admin User|ADMIN|IT|ALL
```

### courses.txt
```
COURSE_CODE|TITLE|CREDITS|INSTRUCTOR_ID|CAPACITY|PREREQUISITES
CS101|Intro to Programming|3|I001|30|
CS201|Data Structures|3|I001|25|CS101
MATH101|Calculus I|4|I002|40|
```

### enrollments.txt
```
ENROLLMENT_ID|STUDENT_ID|COURSE_CODE|SEMESTER|STATUS
E001|S001|CS101|Fall2024|ACTIVE
E002|S001|MATH101|Fall2024|ACTIVE
E003|S002|CS101|Fall2024|DROPPED
```

### grades.txt
```
GRADE_ID|STUDENT_ID|COURSE_CODE|SCORE|LETTER_GRADE|SEMESTER
G001|S001|CS101|85.5|B|Fall2024
G002|S001|MATH101|92.0|A|Fall2024
```

## Alternative: Java Serialization
Instead of text files, you can use Java's built-in serialization:
```java
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.dat"));
out.writeObject(usersList);
out.close();
```

Choose the approach that works best for your team!
