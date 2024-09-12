package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApplication {
    private static ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Main application loop
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> captureStudent();
                case "2" -> searchStudent();
                case "3" -> deleteStudent();
                case "4" -> printStudentReport();
                case "5" -> exitApplication();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // to Display menu options to the user
    private static void displayMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("********************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");
    }

    // Method to capture a new student's details
    private static void captureStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("**********************");

        System.out.print("Enter the student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age = 0;
        while (true) {
            System.out.print("Enter the student age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) break; // Age must be 16 or older
                else System.out.println("Age must be 16 or older.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid age.");
            }
        }

        // Email validation
        String email;
        while (true) {
            System.out.print("Enter the student email: ");
            email = scanner.nextLine();
            if (email.contains("@") && email.contains(".")) break; // Simple email validation
            else System.out.println("Please enter a valid email address.");
        }

        // Course input validation
        String course;
        while (true) {
            System.out.print("Enter the student course: ");
            course = scanner.nextLine();
            if (!course.trim().isEmpty()) break; // Course cannot be empty
            else System.out.println("Course cannot be empty.");
        }

        // Add the new student to the list
        students.add(new Student(id, name, age, email, course));
        System.out.println("Student details have been successfully saved.");
    }

    // Method to search for a student by ID
    private static void searchStudent() {
        System.out.print("Enter the student ID to search: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.id.equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with ID: " + id + " was not found!");
    }

    // Method to delete a student by ID
    private static void deleteStudent() {
        System.out.print("Enter the student ID to delete: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.id.equals(id)) {
                System.out.print("Are you sure you want to delete student " + id + "? (y/n): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    students.remove(student);
                    System.out.println("Student with ID: " + id + " was deleted.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("Student with ID: " + id + " was not found!");
    }

    // Method to print all student reports
    private static void printStudentReport() {
        System.out.println("STUDENT REPORT");
        System.out.println("********************************");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).formattedReport(i + 1));
        }
    }

    // Method to exit the application
    private static void exitApplication() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }
}
