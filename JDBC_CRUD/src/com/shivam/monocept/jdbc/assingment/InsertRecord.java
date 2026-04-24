package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CreateConnection connection = new CreateConnection();
		String SqlQuarry = "insert into student(id,name,age,branch,result) values(?,?,?,?,?)";
		try {
			Connection connect = DriverManager.getConnection(connection.getUrl(), connection.getName(),
					connection.getPassword());
			PreparedStatement statement = connect.prepareStatement(SqlQuarry);
			System.out.print("Enter ID: ");
			int id = scanner.nextInt();

			scanner.nextLine(); // clear buffer

			System.out.print("Enter Name: ");
			String nameInput = scanner.nextLine();

			System.out.print("Enter Age: ");
			int age = scanner.nextInt();

			scanner.nextLine();

			System.out.print("Enter Branch: ");
			String branch = scanner.nextLine();

			System.out.print("Enter Result: ");
			double result = scanner.nextDouble();
			statement.setInt(1, id);
			statement.setString(2, nameInput);
			statement.setInt(3, age);
			statement.setString(4, branch);
			statement.setDouble(5, result);
			statement.executeUpdate();
			connection.Run();
			statement.close();
			connect.close();
		} catch (SQLException e) {

			System.out.println(e.getErrorCode() + e.getMessage());
		}

	}

}
