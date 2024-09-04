package MyPackage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import MyPackage.dao.GradeDAO;
// import MyPackage.dao.StudentDAO;
import MyPackage.model.Grade;

public class GradeService {
    private GradeDAO gradeDAO;
    private Connection connection;

    public GradeService(Connection connection) {
        this.connection = connection;
        gradeDAO = new GradeDAO(connection);
    }

    public void addGrade(Grade grade) {
        try {
            gradeDAO.addGrade(grade);
            System.out.println("Grade added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding grade: " + e.getMessage());
        }
    }

    public Grade getGradeById(int gradeId) {
        try {
            return gradeDAO.getGradeById(gradeId);
        } catch (SQLException e) {
            System.err.println("Error retrieving grade: " + e.getMessage());
            return null;
        }
    }

    public List<Grade> getGradesByStudentId(int studentId) {
        try {
            return gradeDAO.getGradesByStudentId(studentId);
        } catch (SQLException e) {
            System.err.println("Error retrieving grades: " + e.getMessage());
            return null;
        }
    }

    public void updateGrade(Grade grade) {
        try {
            gradeDAO.updateGrade(grade);
            System.out.println("Grade updated successfully!");
        } catch (SQLException e) {
            System.err.println("Error updating grade: " + e.getMessage());
        }
    }

    public double calculateGPA(int studentId) {
        try {
            return gradeDAO.calculateGPA(studentId);
        } catch (SQLException e) {
            System.err.println("Error calculating GPA: " + e.getMessage());
            return 0.0;
        }
    }
}
