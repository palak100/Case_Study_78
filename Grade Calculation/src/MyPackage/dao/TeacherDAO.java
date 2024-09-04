package MyPackage.dao;

import MyPackage.model.Teacher;

import java.sql.*;
import java.util.*;

public class TeacherDAO {
    private Connection connection;

    public TeacherDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        String query = "INSERT INTO Teacher (name,date_of_birth,address,email) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,teacher.getName());
            statement.setString(2,teacher.getDateOfBirth());
            statement.setString(3,teacher.getAddress());
            statement.setString(4,teacher.getEmail());
            statement.executeUpdate();
        }
    }

    public Teacher getTeacherById(int teacherId) throws SQLException {
        String query = "SELECT * FROM Teacher WHERE teacher_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, teacherId);
            try (ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    return new Teacher(
                        rs.getInt("teacher_id"),
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

    public List<Teacher> getAllTeachers() throws SQLException {
        String query = "SELECT * FROM Teacher";
        List<Teacher> teachers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery()) {
                while(rs.next()){
                    teachers.add(new Teacher(
                        rs.getInt("teacher_id"),
                        rs.getString("name"),
                        rs.getString("date_of_birth"),
                        rs.getString("address"),
                        rs.getString("email")
                    ));
                }
            }
        return teachers;
    }

    public void updateTeacher(Teacher teacher) throws SQLException {
        String query  = "UPDATE teacher SET name = ? , date_of_birth = ? , address = ? , email = ? WHERE teacher_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,teacher.getName());
            statement.setString(2,teacher.getDateOfBirth());
            statement.setString(3,teacher.getAddress());
            statement.setString(4, teacher.getEmail());
            statement.setInt(5, teacher.getTeacherId());

            statement.executeUpdate();
        }
    }

    public void deleteTeacher(int teacher_id) throws SQLException {
        String query = "DELETE FROM Teacher WHERE teacher_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,teacher_id);
            statement.executeUpdate();
        }
    }
}
