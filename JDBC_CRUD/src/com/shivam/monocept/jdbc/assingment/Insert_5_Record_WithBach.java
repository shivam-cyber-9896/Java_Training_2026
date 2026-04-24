package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_5_Record_WithBach {

	public static void main(String[] args) {
		CreateConnection connection = new CreateConnection();
		String SqlQuarry = "insert into student(id,name,age,branch,result) values(?,?,?,?,?)";
		
			Connection connect;
			try {
				connect = DriverManager.getConnection(connection.getUrl(), connection.getName(),
						connection.getPassword());
		
				PreparedStatement statement = connect.prepareStatement(SqlQuarry);
				statement.setInt(1, 12);
				statement.setString(2, "rohit");
				statement.setInt(3, 12);
				statement.setString(4, "bba");
				statement.setDouble(5, 22);
				statement.addBatch();
				//2
				statement.setInt(1, 13);
				statement.setString(2, "rohit");
				statement.setInt(3, 12);
				statement.setString(4, "bba");
				statement.setDouble(5, 22);
				statement.addBatch();
				//3
				statement.setInt(1, 14);
				statement.setString(2, "rohit");
				statement.setInt(3, 12);
				statement.setString(4, "bba");
				statement.setDouble(5, 22);
				statement.addBatch();
				//4
				statement.setInt(1, 15);
				statement.setString(2, "rohit");
				statement.setInt(3, 12);
				statement.setString(4, "bba");
				statement.setDouble(5, 22);
				statement.addBatch();
				//5
				statement.setInt(1, 16);
				statement.setString(2, "rohit");
				statement.setInt(3, 12);
				statement.setString(4, "bba");
				statement.setDouble(5, 22);
				
				statement.addBatch();
				//------------------------------------------------------------------------
				statement.executeBatch();
				connection.Run();
			} catch (SQLException e) {
				
			}
	}

}
