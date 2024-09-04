package MyPackage.dao;

import MyPackage.model.Course;

import java.sql.*;
import java.util.*;

public class CourseDAO {
    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void addCourse(Course course) throws SQLException {
        String query = "INSERT INTO Course (title,description,teacher_id) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,course.getTitle());
            statement.setString(2,course.getDescription());
            statement.setInt(3,course.getTeacherId());

            statement.executeUpdate();
        }
    }

    public Course getCourseById(int course_id) throws SQLException {
        String query = "SELECT * FROM Course WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,course_id);
            try (ResultSet rs = statement.executeQuery()) {
                if(rs.next()){
                    return new Course(
                        rs.getInt("course_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("teacher_id")
                    );
                }
            }
        }
        return null;
    }

    public List<Course> getAllCourse() throws SQLException {
        String query = "SELECT * FROM Course";
        List<Course> courses = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery()) {
            while(rs.next()){
                courses.add(new Course(
                    rs.getInt("course_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("teacher_id")
                ));
            }    
        }
        return courses;
    }

    public void updateCourse(Course course) throws SQLException {
        String query = "UPDATE Course SET title = ?,description = ?,teacher_id = ? WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getTitle());
            statement.setString(2, course.getDescription());
            statement.setInt(3, course.getTeacherId());
            statement.setInt(4,course.getCourseId());

            statement.executeUpdate();
        }
    }

    public void deleteCourse(int courseId) throws SQLException {
        String query = "DELETE FROM Course WHERE course_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,courseId);

            statement.executeUpdate();
        }
    }
}
