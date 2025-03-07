package dao;

import model.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User authenticateUser(String username, String password) {
        String sql = "SELECT * FROM utilisateur WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, hashPassword(password)); // Implement secure password hashing

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(rs.getString("role"));
                    user.setEmail(rs.getString("email"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerUser(User user, String password) {
        String sql = "INSERT INTO utilisateur (username, password, role, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, hashPassword(password)); // Implement secure password hashing
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getEmail());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Basic password hashing (IMPORTANT: Use a more secure method in production)
    private String hashPassword(String password) {
        // In a real-world scenario, use strong hashing like BCrypt
        return password;
    }
}