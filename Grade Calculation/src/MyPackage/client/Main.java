package MyPackage.client;

import MyPackage.service.StudentService;
import MyPackage.service.TeacherService;
import MyPackage.service.CourseService;
import MyPackage.service.GradeService;

import MyPackage.model.Student;
import MyPackage.model.Teacher;
import MyPackage.model.Course;
import MyPackage.model.Grade;

import MyPackage.util.DButil;

import java.sql.*;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static StudentService studentService;
    private static TeacherService teacherService;
    private static CourseService courseService;
    private static GradeService gradeService;

    public static void main(String[] args) {
        try (Connection connection = DButil.getConnection()) {
            studentService = new StudentService(connection);
            teacherService = new TeacherService(connection);
            courseService = new CourseService(connection);
            gradeService = new GradeService(connection);

            boolean exit = false;
            while (!exit) {
                showMainMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        manageStudents();
                        break;
                    case 2:
                        manageTeachers();
                        break;
                    case 3:
                        manageCourses();
                        break;
                    case 4:
                        manageGrades();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    private static void showMainMenu() {
        System.out.println("\nSchool Management System");
        System.out.println("1. Student Management");
        System.out.println("2. Teacher Management");
        System.out.println("3. Course Management");
        System.out.println("4. Grade Management");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void manageStudents() {
        boolean back = false;
        while (!back) {
            System.out.println("\nStudent Management");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageTeachers() {
        boolean back = false;
        while (!back) {
            System.out.println("\nTeacher Management");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teacher");
            System.out.println("3. View All Teachers");
            System.out.println("4. Update Teacher");
            System.out.println("5. Delete Teacher");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    viewTeacher();
                    break;
                case 3:
                    viewAllTeachers();
                    break;
                case 4:
                    updateTeacher();
                    break;
                case 5:
                    deleteTeacher();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageCourses() {
        boolean back = false;
        while (!back) {
            System.out.println("\nCourse Management");
            System.out.println("1. Add Course");
            System.out.println("2. View Course");
            System.out.println("3. View All Courses");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewCourse();
                    break;
                case 3:
                    viewAllCourses();
                    break;
                case 4:
                    updateCourse();
                    break;
                case 5:
                    deleteCourse();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageGrades() {
        boolean back = false;
        while (!back) {
            System.out.println("\nGrade Management");
            System.out.println("1. Assign Grade");
            System.out.println("2. View Grade");
            System.out.println("3. View Grades by Student");
            System.out.println("4. Update Grade");
            System.out.println("5. Calculate GPA");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    assignGrade();
                    break;
                case 2:
                    viewGrade();
                    break;
                case 3:
                    viewGradesByStudent();
                    break;
                case 4:
                    updateGrade();
                    break;
                case 5:
                    calculateGPA();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Student management methods using StudentService
    private static void addStudent() {
        System.out.println("Enter StudentId : ");
        int StudentId =  Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Student student = new Student(StudentId,name, dob, address, email);
        studentService.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void viewStudent() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() {
        List<Student> students = studentService.getAllStudent();
        if (students != null && !students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            System.out.print("Enter new name (or press Enter to skip): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) student.setName(name);

            System.out.print("Enter new date of birth (yyyy-mm-dd) (or press Enter to skip): ");
            String dob = scanner.nextLine();
            if (!dob.isEmpty()) student.setDateOfBirth(dob);

            System.out.print("Enter new address (or press Enter to skip): ");
            String address = scanner.nextLine();
            if (!address.isEmpty()) student.setAddress(address);

            System.out.print("Enter new email (or press Enter to skip): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) student.setEmail(email);

            studentService.updateStudent(student);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            studentService.deleteStudent(studentId);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Teacher management methods using TeacherService
    private static void addTeacher() {
        System.out.println("Enter TeacherId : ");
        int TeacherId =  Integer.parseInt(scanner.nextLine());
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Teacher teacher = new Teacher(TeacherId, name, dob, address, email);
        teacherService.addTeacher(teacher);
        System.out.println("Teacher added successfully.");
    }

    private static void viewTeacher() {
        System.out.print("Enter teacher ID: ");
        int teacherId = Integer.parseInt(scanner.nextLine());
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher != null) {
            System.out.println(teacher);
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private static void viewAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        if (teachers != null && !teachers.isEmpty()) {
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        } else {
            System.out.println("No teachers found.");
        }
    }

    private static void updateTeacher() {
        System.out.print("Enter teacher ID: ");
        int teacherId = Integer.parseInt(scanner.nextLine());
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher != null) {
            System.out.print("Enter new name (or press Enter to skip): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) teacher.setName(name);

            System.out.print("Enter new date of birth (yyyy-mm-dd) (or press Enter to skip): ");
            String dob = scanner.nextLine();
            if (!dob.isEmpty()) teacher.setDateOfBirth(dob);

            System.out.print("Enter new address (or press Enter to skip): ");
            String address = scanner.nextLine();
            if (!address.isEmpty()) teacher.setAddress(address);

            System.out.print("Enter new email (or press Enter to skip): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) teacher.setEmail(email);

            teacherService.updateTeacher(teacher);
            System.out.println("Teacher updated successfully.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private static void deleteTeacher() {
        System.out.print("Enter teacher ID: ");
        int teacherId = Integer.parseInt(scanner.nextLine());
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher != null) {
            teacherService.deleteTeacher(teacherId);
            System.out.println("Teacher deleted successfully.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    // Course management methods using CourseService
    private static void addCourse() {
        System.out.println("Enter CourseId : ");
        int CourseId =  Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        System.out.print("Enter course description: ");
        String description = scanner.nextLine();
        System.out.print("Enter teacher ID: ");
        int teacherId = Integer.parseInt(scanner.nextLine());

        Course course = new Course(CourseId,title, description, teacherId);
        courseService.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private static void viewCourse() {
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void viewAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses != null && !courses.isEmpty()) {
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found.");
        }
    }

    private static void updateCourse() {
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            System.out.print("Enter new title (or press Enter to skip): ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) course.setTitle(title);

            System.out.print("Enter new description (or press Enter to skip): ");
            String description = scanner.nextLine();
            if (!description.isEmpty()) course.setDescription(description);

            courseService.updateCourse(course);
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void deleteCourse() {
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            courseService.deleteCourse(courseId);
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Grade management methods using GradeService
    private static void assignGrade() {
        System.out.println("Enter GradeId : ");
        int gradeId =  Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Grade gradeObj = new Grade(gradeId ,studentId, courseId, grade);
        gradeService.addGrade(gradeObj);
        System.out.println("Grade assigned successfully.");
    }

    private static void viewGrade() {
        System.out.print("Enter grade ID: ");
        int gradeId = Integer.parseInt(scanner.nextLine());
        Grade grade = gradeService.getGradeById(gradeId);
        if (grade != null) {
            System.out.println(grade);
        } else {
            System.out.println("Grade not found.");
        }
    }

    private static void viewGradesByStudent() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);
        if (grades != null && !grades.isEmpty()) {
            for (Grade grade : grades) {
                System.out.println(grade);
            }
        } else {
            System.out.println("No grades found for this student.");
        }
    }

    private static void updateGrade() {
        System.out.print("Enter grade ID: ");
        int gradeId = Integer.parseInt(scanner.nextLine());
        Grade grade = gradeService.getGradeById(gradeId);
        if (grade != null) {
            System.out.print("Enter new grade (or press Enter to skip): ");
            String newGrade = scanner.nextLine();
            if (!newGrade.isEmpty()) grade.setGrade(newGrade);

            gradeService.updateGrade(grade);
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Grade not found.");
        }
    }

    private static void calculateGPA() {
        System.out.print("Enter student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        double gpa = gradeService.calculateGPA(studentId);
        System.out.println("GPA of student ID " + studentId + " is: " + gpa);
    }
}
