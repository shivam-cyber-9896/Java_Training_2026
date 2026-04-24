package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayByBranch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CreateConnection connection = new CreateConnection();

        String sqlQuery = "SELECT * FROM student WHERE branch = ?";

        try {
            Connection connect = DriverManager.getConnection(
                    connection.getUrl(),
                    connection.getName(),
                    connection.getPassword()
            );

            PreparedStatement statement = connect.prepareStatement(sqlQuery);

          
            System.out.print("Enter Branch : ");
            String branch = scanner.nextLine();

           
            statement.setString(1, branch);

          
            ResultSet resultset = statement.executeQuery();

            boolean found = false;

           
            while (resultset.next()) {
                found = true;

                System.out.println("----------------------------");
                System.out.println("ID: " + resultset.getInt("id"));
                System.out.println("Name: " + resultset.getString("name"));
                System.out.println("Age: " + resultset.getInt("age"));
                System.out.println("Branch: " + resultset.getString("branch"));
                System.out.println("Result: " + resultset.getDouble("result"));
            }

           
            if (!found) {
                System.out.println("No students found in this branch.");
            }

           
            resultset.close();
            statement.close();
            connect.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}