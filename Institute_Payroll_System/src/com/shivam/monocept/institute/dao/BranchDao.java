package com.shivam.monocept.institute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BranchDao {
	 public void getAllBranches(Connection connection) throws Exception {

		    String sql = "SELECT branch_id, branch_name FROM branch";

		    try (PreparedStatement statement = connection.prepareStatement(sql);
		         ResultSet resultset = statement.executeQuery()) {

		        while (resultset.next()) {
		            System.out.println(
		                resultset.getInt("branch_id") + " - " + resultset.getString("branch_name")
		            );
		        }
		    }
		}
	 
	 public boolean isBrenchAvailable(int id, Connection connection) throws Exception {

		    String query = "SELECT 1 FROM branch WHERE branch_id = ?";

		    PreparedStatement statement = connection.prepareStatement(query);
		    statement.setInt(1, id);

		    ResultSet resultset = statement.executeQuery();

		    return resultset.next(); 
		}
	 public int getBranchId(String branchName, Connection connection) throws Exception {

		    String sql = "SELECT branch_id FROM branch WHERE branch_name = ?";

		    try (PreparedStatement statement = connection.prepareStatement(sql)) {

		        statement.setString(1, branchName);

		        try (ResultSet rs = statement.executeQuery()) {

		            if (rs.next()) 
		                return rs.getInt("branch_id");
		           
		                throw new Exception("Branch not found: " + branchName);
		            
		        
		    }
		}
	 
}
	 public String getBranchName(int branchId, Connection connection) throws Exception {

		    String sql = "SELECT branch_name FROM branch WHERE branch_id = ?";

		    try (PreparedStatement statement = connection.prepareStatement(sql)) {

		        statement.setInt(1, branchId);

		        try (ResultSet rs = statement.executeQuery()) {

		            if (rs.next()) {
		                return rs.getString("branch_name"); 
		            } else {
		                throw new Exception("Branch not found for ID: " + branchId);
		            }
		        }
		    }
		}
}
