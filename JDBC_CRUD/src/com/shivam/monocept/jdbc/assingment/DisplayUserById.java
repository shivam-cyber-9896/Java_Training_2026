package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayUserById {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CreateConnection connection = new CreateConnection();
		String SqlQuarry = "select * from student where id=?";
		Connection connect;
		
			try {
				connect = DriverManager.getConnection(connection.getUrl(), connection.getName(),
						connection.getPassword());
			PreparedStatement statement = connect.prepareStatement(SqlQuarry);
			System.out.print("Enter ID: ");
			int id = scanner.nextInt();
			 statement.setInt(1, id);

	            
	            ResultSet rs = statement.executeQuery();

	           
	            if (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id"));
	                System.out.println("Name: " + rs.getString("name"));
	                System.out.println("Age: " + rs.getInt("age"));
	                System.out.println("Branch: " + rs.getString("branch"));
	                System.out.println("Result: " + rs.getDouble("result"));
	            } else {
	                System.out.println("No student found with ID: " + id);
	            }

	          
	            rs.close();
	            statement.close();
	            connect.close();
	            scanner.close();

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

}
