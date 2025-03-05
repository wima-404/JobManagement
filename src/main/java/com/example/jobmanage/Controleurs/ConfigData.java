package com.example.jobmanage.Controleurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigData {
    private static final String URL = "jdbc:mysql://localhost:3306/edumanage";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }
}
