package MyPackage.dao;

import MyPackage.model.Grade;

import java.sql.*;
import java.util.*;

public class GradeDAO {
    private Connection connection;

    public GradeDAO(Connection connection) {
        this.connection = connection;
    }    

    public void addGrade(Grade grade) throws SQLException {
        String query = "INSERT INTO Grade (student_id, course_id, grade) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, grade.getStudentId());
            statement.setInt(2, grade.getCourseId());
            statement.setString(3, grade.getGrade());
            statement.executeUpdate();
        }
    }

    public Grade getGradeById(int gradeId) throws SQLException {
        String query = "SELECT * FROM Grade WHERE grade_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, gradeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Grade(
                        resultSet.getInt("grade_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"),
                        resultSet.getString("grade")
                    );
                }
            }
        }
        return null;
    }

    public List<Grade> getGradesByStudentId(int studentId) throws SQLException {
        String query = "SELECT * FROM Grade WHERE student_id = ?";
        List<Grade> grades = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    grades.add(new Grade(
                        resultSet.getInt("grade_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"),
                        resultSet.getString("grade")
                    ));
                }
            }
        }
        return grades;
    }

    public void updateGrade(Grade grade) throws SQLException {
        String query = "UPDATE Grade SET student_id = ?, course_id = ?, grade = ? WHERE grade_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, grade.getStudentId());
            statement.setInt(2, grade.getCourseId());
            statement.setString(3, grade.getGrade());
            statement.setInt(4, grade.getGradeId());
            statement.executeUpdate();
        }
    }

    public double calculateGPA(int student_id) throws SQLException {
        String query = "SELECT grade FROM Grade WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student_id);
            try (ResultSet rs = statement.executeQuery()) {
                int totalCourses = 0;
                double totalPoints = 0;
                while(rs.next()){
                    String grade = rs.getString("grade");
                    totalPoints += gradeToPoints(grade);
                    totalCourses++;
                }
                if(totalPoints == 0){
                    return 0.0;
                }
                return totalPoints / totalCourses;
            }
        }
    }

    private double gradeToPoints(String grade){
        switch(grade.toUpperCase()){
            case "A" : return 4.0;
            case "B" : return 3.0;
            case "C" : return 2.0;
            case "D" : return 1.0;
            case "F" : return 0.0;
            default : return 0.0;
        }
    }
}
