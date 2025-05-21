package com.socialservice.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserManagement {
    
    public void registerVolunteer(String name, String contact) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO volunteers (name, contact) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, contact);
            statement.executeUpdate();
            System.out.println("Volunteer registered successfully.");
        } catch (SQLException e) {
            System.out.println("Error in registering volunteer: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
