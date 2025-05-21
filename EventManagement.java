package com.socialservice.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventManagement {
    public void createEvent(String eventName, String eventDate, String location) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO events (name, date, location) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, eventName);
            statement.setString(2, eventDate);
            statement.setString(3, location);
            statement.executeUpdate();
            System.out.println("Event created successfully.");
        } catch (SQLException e) {
            System.out.println("Error in creating event: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
