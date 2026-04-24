package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateStudentName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CreateConnection connection = new CreateConnection();

        String sqlQuery = "UPDATE student SET name = ? WHERE id = ?";
        String selectQuery = "SELECT * FROM student WHERE id = ?";
        try {
            Connection connect = DriverManager.getConnection(
                    connection.getUrl(),
                    connection.getName(),
                    connection.getPassword()
            );

            PreparedStatement statement = connect.prepareStatement(sqlQuery);

          
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();

            scanner.nextLine(); 
            System.out.print("Enter New Name: ");
            String newName = scanner.nextLine();

          
            statement.setString(1, newName);
            statement.setInt(2, id);

          
            int rows = statement.executeUpdate();

            if (rows > 0) {
            	PreparedStatement statement2 = connect.prepareStatement(selectQuery);
            	statement2.setInt(1, id);
            	 ResultSet resultset= statement2.executeQuery();
            	 resultset.next();
                     System.out.println("----- Updated Record -----");
                     System.out.println("ID: " + resultset.getInt("id"));
                     System.out.println("Name: " + resultset.getString("name"));
                     System.out.println("Age: " + resultset.getInt("age"));
                     System.out.println("Branch: " + resultset.getString("branch"));
                     System.out.println("Result: " + resultset.getDouble("result"));
                 
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