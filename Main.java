package com.socialservice.management;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate module classes
        UserManagement userManagement = new UserManagement();
        EventManagement eventManagement = new EventManagement();
        AttendanceManagement attendanceManagement = new AttendanceManagement();
        ReportGeneration reportGeneration = new ReportGeneration();
        FeedbackAndRating feedbackAndRating = new FeedbackAndRating();
      //  Notification notification = new Notification();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Social Service Management System ---");
            System.out.println("1. Register Volunteer");
            System.out.println("2. Create Event");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Generate Event Report");
            System.out.println("5. Submit Feedback");
            System.out.println("6. Send Notification");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Register a new volunteer
                    System.out.print("Enter volunteer name: ");
                    String volunteerName = scanner.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = scanner.nextLine();
                    userManagement.registerVolunteer(volunteerName, contact);
                    break;

                case 2:
                    // Create a new event
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter event date (YYYY-MM-DD): ");
                    String eventDate = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String location = scanner.nextLine();
                    eventManagement.createEvent(eventName, eventDate, location);
                    break;

                case 3:
                    // Mark attendance for a volunteer at an event
                    System.out.print("Enter volunteer name: ");
                    String volunteer_name = scanner.nextLine();
                    System.out.print("Enter event name: ");
                    String eventForAttendance = scanner.nextLine();
                    System.out.print("Did the volunteer attend? (true/false): ");
                    boolean attended = scanner.nextBoolean();
                    attendanceManagement.markAttendance(volunteer_name, eventForAttendance, attended);
                    break;

                case 4:
                    // Generate a report for all events
                    System.out.println("\n--- Event Report ---");
                    reportGeneration.generateEventReport();
                    break;

                case 5:
                    // Submit feedback for an event
                    System.out.print("Enter volunteer name: ");
                    String volunteerForFeedback = scanner.nextLine();
                    System.out.print("Enter feedback: ");
                    String feedback = scanner.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int rating = scanner.nextInt();
                    feedbackAndRating.submitFeedback(volunteerForFeedback, feedback, rating);
                    break;

//                case 6:
//                     Send a notification
//                    System.out.print("Enter message: ");
//                    String message = scanner.nextLine();
//                    System.out.print("Enter recipient: ");
//                    String recipient = scanner.nextLine();
//                   notification.sendNotification(message, recipient);
//                    break;

                case 7:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
