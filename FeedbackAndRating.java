package com.socialservice.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackAndRating {
    public void submitFeedback(String volunteerName, String feedback, int rating) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO feedback (volunteer_name, feedback, rating) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, volunteerName);
            statement.setString(2, feedback);
            statement.setInt(3, rating);
            statement.executeUpdate();
            System.out.println("Feedback submitted successfully.");
        } catch (SQLException e) {
            System.out.println("Error in submitting feedback: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}
