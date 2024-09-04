package MyPackage.dao;

import MyPackage.model.Student;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    } 

    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO Student (name,date_of_birth,address,email) VALUES ( ?, ?, ?, ? )";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,student.getName());
            statement.setString(2,student.getDateOfBirth());
            statement.setString(3,student.getAddress());
            statement.setString(4,student.getEmail());
            statement.executeUpdate();
        }
    }

    public Student getStudentById(int studentId) throws SQLException {
        String query = "SELECT * FROM Student WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,studentId);
            try (ResultSet rs = statement.executeQuery()) {
                if(rs.next()){
                    return new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("date_of_birth"),
                        rs.getString("address"),
                        rs.getString("email")
                    );
                }
            }
        }
        return null;
    }

    public List<Student> getAllStudents() throws SQLException {
        String query = "SELECT * FROM Student";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query); 
            ResultSet rs = statement.executeQuery()) {
            while(rs.next()){
                students.add(new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("date_of_birth"),
                    rs.getString("address"),
                    rs.getString("email")
                ));
            }
        }
        return students;
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE Student SET name = ?, date_of_birth = ?, address = ?, email = ? WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,student.getName());
            statement.setString(2, student.getDateOfBirth());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getStudentId());
            statement.executeUpdate();
        }
    }

    public void deleteStudent(int student_id) throws SQLException {
        String query = "DELETE FROM Student WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student_id);
            statement.executeUpdate();
        }
    }
}
