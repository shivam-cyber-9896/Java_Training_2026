package com.shivam.monocept.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_Conection {
public static void main(String[] argus)
{
String url="jdbc:mysql://localhost:3306/student";
String name="root";
String password="shivam@9896";
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
