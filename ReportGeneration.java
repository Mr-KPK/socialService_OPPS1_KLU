package com.socialservice.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportGeneration {
    public void generateEventReport() {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM attendance";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String eventName = resultSet.getString("event_name");
                String volunteerName = resultSet.getString("name");
                boolean attended = resultSet.getBoolean("attended");
                System.out.println("Event: " + eventName + ", Volunteer: " + volunteerName + ", Attended: " + attended);
            }
        } catch (SQLException e) {
            System.out.println("Error in generating event report: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
