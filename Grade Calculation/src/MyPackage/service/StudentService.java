package MyPackage.service;

import MyPackage.dao.StudentDAO;
import MyPackage.model.Student;

import java.sql.*;
import java.util.*;

public class StudentService {
    private StudentDAO studentDAO;
    private Connection connection;

    
    public StudentService(Connection connection){
        this.connection = connection;
        studentDAO = new StudentDAO(connection);
    }

    public void addStudent(Student student){
        try{
            studentDAO.addStudent(student);
            System.out.println("Student added successfully");
        }catch(SQLException e){
            System.out.println("Error adding student : " + e.getMessage());
        }
    }

    public Student getStudentById(int studentId){
        try {
            return studentDAO.getStudentById(studentId);
        } catch (SQLException e) {
            System.out.println("Error getting student : " + e.getMessage());
            return null;
        }
    }

    public List<Student> getAllStudent() {
        try {
            return studentDAO.getAllStudents();
        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
            return null;
        }
    }

    public void updateStudent(Student student) {
        try {
            studentDAO.updateStudent(student);
            System.out.println("Student updated successfully");
        } catch (SQLException e) {
            System.err.println("Error updating students: " + e.getMessage());
        }
    }

    public void deleteStudent(int studentId) {
        try {
            studentDAO.deleteStudent(studentId);
        } catch (SQLException e) {    
            System.err.println("Error deleting students: " + e.getMessage());
        }
    }
}
