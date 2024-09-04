package MyPackage.util;

import java.sql.*;

public class DButil {
    private static final String URl = "jdbc:mysql://localhost:3306/SchoolManagement";
    private static final String USER = "root";
    private static final String PASSWORD = "Root@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URl, USER, PASSWORD);
    } 
}
