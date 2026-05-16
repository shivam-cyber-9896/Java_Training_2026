package com.shivam.monocept.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shivam.monocept.studentcourse.Util.DBConnection;

public class AdminDAO {
	 public boolean validateAdmin(String username, String password) {

	        boolean status = false;

	        try {

	            Connection connection = DBConnection.getConnection();

	            String query =
	                    "SELECT * FROM admin WHERE username=? AND password=?";

	            PreparedStatement preparedStatement = connection.prepareStatement(query);

	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
                System.out.println("run ?");
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                status = true;
	            }
                      resultSet.close();
                      preparedStatement.close();
                      connection.close();
	        } catch (Exception e) {
	        	 System.out.println("Error ="+e);
	        }

	        return status;
	    }
}
