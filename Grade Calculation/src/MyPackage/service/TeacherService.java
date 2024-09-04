package MyPackage.service;

// import MyPackage.dao.StudentDAO;
import MyPackage.dao.TeacherDAO;
import MyPackage.model.Teacher;

import java.sql.*;
import java.util.*;

public class TeacherService  {
    private TeacherDAO teacherDAO;
    private Connection connection;

    public TeacherService(Connection connection) {
        this.connection = connection;
        teacherDAO = new TeacherDAO(connection);
    }

    public void addTeacher(Teacher teacher) {
        try {
            teacherDAO.addTeacher(teacher);
            System.out.println("Teacher added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding teacher: " + e.getMessage());
        }
    }

    public Teacher getTeacherById(int teacherId) {
        try {
            return teacherDAO.getTeacherById(teacherId);
        } catch (SQLException e) {
            System.err.println("Error retrieving teacher: " + e.getMessage());
            return null;
        }
    }

    public List<Teacher> getAllTeachers() {
        try {
            return teacherDAO.getAllTeachers();
        } catch (SQLException e) {
            System.err.println("Error retrieving teachers: " + e.getMessage());
            return null;
        }
    }

    public void updateTeacher(Teacher teacher) {
        try {
            teacherDAO.updateTeacher(teacher);
            System.out.println("Teacher updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error updating teacher: " + e.getMessage());
        }
    }

    public void deleteTeacher(int teacherId) {
        try {
            teacherDAO.deleteTeacher(teacherId);
            System.out.println("Teacher deleted successfully!");
        } catch (SQLException e) {
            System.err.println("Error deleting teacher: " + e.getMessage());
        }
    }
}
