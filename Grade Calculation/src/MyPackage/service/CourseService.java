package MyPackage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import MyPackage.dao.CourseDAO;
// import MyPackage.dao.StudentDAO;
import MyPackage.model.Course;

public class CourseService {
    private CourseDAO courseDAO;
    private Connection connection;

    public CourseService(Connection connection) {
        this.connection = connection;
        courseDAO = new CourseDAO(connection);
    }

    public void addCourse(Course course) {
        try {
            courseDAO.addCourse(course);
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding course: " + e.getMessage());
        }
    }

    public Course getCourseById(int courseId) {
        try {
            return courseDAO.getCourseById(courseId);
        } catch (SQLException e) {
            System.err.println("Error retrieving course: " + e.getMessage());
            return null;
        }
    }

    public List<Course> getAllCourses() {
        try {
            return courseDAO.getAllCourse();
        } catch (SQLException e) {
            System.err.println("Error retrieving courses: " + e.getMessage());
            return null;
        }
    }

    public void updateCourse(Course course) {
        try {
            courseDAO.updateCourse(course);
            System.out.println("Course updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error updating course: " + e.getMessage());
        }
    }

    public void deleteCourse(int courseId) {
        try {
            courseDAO.deleteCourse(courseId);
            System.out.println("Course deleted successfully!");
        } catch (SQLException e) {
            System.err.println("Error deleting course: " + e.getMessage());
        }
    }
}
