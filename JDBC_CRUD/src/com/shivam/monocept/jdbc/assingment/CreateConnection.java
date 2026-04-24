package com.shivam.monocept.jdbc.assingment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateConnection {
	private final String url="jdbc:mysql://localhost:3306/student";
	private  final String name="root";
	private final String password="shivam@9896";
public void Run() {
	{
		
		  String sqlQuerry="Select* from student";
		try {
			Connection connection=DriverManager.getConnection(url,name,password);
			PreparedStatement statement=connection.prepareStatement(sqlQuerry);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next())
			{
				System.out.println(" Student details id "+resultset.getInt("id")
				+"    Name   "+resultset.getString(2)+" Age "+resultset.getInt(3)
				+" branch "+resultset.getString(4)+" result "+resultset.getFloat(5)
						
						);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
}

}
public String getUrl() {
	return url;
}
public String getName() {
	return name;
}
public String getPassword() {
	return password;
}
}
