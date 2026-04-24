package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudentByMarks {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CreateConnection connection = new CreateConnection();

        String deleteQuery = "DELETE  from student WHERE result < ?";

        try {
            Connection connect = DriverManager.getConnection(
                    connection.getUrl(),
                    connection.getName(),
                    connection.getPassword()
            );

            System.out.print("Enter Marks Threshold: ");
            double marks=scanner.nextDouble();
            PreparedStatement statement = connect.prepareStatement(deleteQuery);
            statement.setDouble(1, marks);   

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully! how many" + rows);
            } else {
                System.out.println(" No student has below marks");
            }

            statement.close();
            connect.close();
            scanner.close();

        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        }
}
