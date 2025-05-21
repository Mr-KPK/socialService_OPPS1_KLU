package com.socialservice.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceManagement {
    public void markAttendance(String name, String eventName, boolean attended) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO attendance ( name,eventName, attended) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, eventName);
            statement.setBoolean(3, attended);
            statement.executeUpdate();
            System.out.println("Attendance marked successfully.");
        } catch (SQLException e) {
            System.out.println("Error in marking attendance: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
