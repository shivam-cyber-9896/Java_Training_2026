package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudentById {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CreateConnection connection = new CreateConnection();

        String deleteQuery = "DELETE FROM student WHERE id = ?";

        try {
            Connection connect = DriverManager.getConnection(
                    connection.getUrl(),
                    connection.getName(),
                    connection.getPassword()
            );

            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            PreparedStatement statement = connect.prepareStatement(deleteQuery);
            statement.setInt(1, id);   

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println(" No student found with ID: " + id);
            }

            statement.close();
            connect.close();
            scanner.close();

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}