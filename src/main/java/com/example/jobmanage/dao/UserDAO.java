package com.example.jobmanage.dao;

import com.example.jobmanage.Controleurs.ConfigData;
import com.example.jobmanage.model.User;
import com.example.jobmanage.model.loginUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean registerUser(loginUser user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection con = ConfigData.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

              pstmt.setString(1,"username");
              pstmt.setString(2,"password");


            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection con = ConfigData.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

