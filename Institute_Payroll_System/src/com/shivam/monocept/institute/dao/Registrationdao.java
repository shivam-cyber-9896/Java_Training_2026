package com.shivam.monocept.institute.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shivam.monocept.institute.util.DBUtil;

public class Registrationdao {
	public boolean isDuplicate(int studentId, String course, Connection connection) throws Exception {

	    String sql = "SELECT 1 FROM registration WHERE student_id=? AND course_name=?";

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setInt(1, studentId);
	        statement.setString(2, course);

	        try (ResultSet rs = statement.executeQuery()) {
	            return rs.next();
	        }
	    }
	}

	    public void registerCourse(int studentId, String course, double fee, Connection connection) throws Exception {
	        String sql = "INSERT INTO registration (student_id, course_name, fees_paid) VALUES (?, ?, ?)";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        	statement.setInt(1, studentId);
	        	statement.setString(2, course);
	        	statement.setDouble(3, fee);
	        	statement.executeUpdate();
	        }
	    }

	    public void deleteRegistration(int studentId, String course, Connection connection) throws Exception {
	        String sql = "DELETE FROM registration WHERE student_id=? AND course_name=?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, studentId);
	            statement.setString(2, course);
	          int row=  statement.executeUpdate();
	          if(row <0)
	        	  throw new Exception("No registration found to delete");
	        }
	    }

	    public void deleteAllRegistrations(int studentId, Connection connection) throws Exception {
	        String sql = "DELETE FROM registration WHERE student_id=?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, studentId);
	            statement.executeUpdate();
	        }
	    }

	    public List<String> getAllStudentCourseDetails() throws Exception {

	        List<String> list = new ArrayList<>();

	        String sql = "{CALL getAllStudentCourseDetails()}";

	        try (Connection connection = DBUtil.getConnection();
	             CallableStatement callableStatement = connection.prepareCall(sql);
	             ResultSet rs = callableStatement.executeQuery()) {

	            while (rs.next()) {

	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String branch = rs.getString("branch");
	                String course = rs.getString("course_name");
	                double fee = rs.getDouble("fees_paid");

	                String row = id + " | " + name + " | " + branch +
	                             " | " + course + " | $" + fee;

	                list.add(row);
	            }
	        }

	        return list;
	    }

	    public List<String> getCoursesByStudent(int id) throws Exception {

	        List<String> list = new ArrayList<>();

	        String sql = "SELECT course_name, fees_paid FROM registration WHERE student_id=?";

	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setInt(1, id);
	            ResultSet rs = statement.executeQuery();

	            while (rs.next()) {
	                String course = rs.getString("course_name");
	                double fee = rs.getDouble("fees_paid");

	                list.add(course + " ($" + fee + ")");
	            }
	        }

	        return list;
	    }

	    public List<String> getHighPaying(double amount) throws Exception {

	        List<String> list = new ArrayList<>();

	        String sql = "{CALL getHighPaying(?)}";

	        try (Connection connection = DBUtil.getConnection();
	             CallableStatement callableStatement = connection.prepareCall(sql)) {

	            callableStatement.setDouble(1, amount);  

	            ResultSet rs = callableStatement.executeQuery();

	            while (rs.next()) {
	                String name = rs.getString("name");
	                String course = rs.getString("course_name");
	                double fee = rs.getDouble("fees_paid");

	                list.add(name + " | " + course + " | ₹" + fee);
	            }
	        }

	        return list;
	    }

	    public List<String> getCourseCount() throws Exception {

	        List<String> list = new ArrayList<>();

	        String sql = "{CALL getCourseCount()}";

	        try (Connection connection = DBUtil.getConnection();
	             CallableStatement callableStatement = connection.prepareCall(sql);
	             ResultSet ResultSet = callableStatement.executeQuery()) {

	            while (ResultSet.next()) {
	                String course = ResultSet.getString("course_name");
	                int count = ResultSet.getInt("total");

	                list.add(course + " → " + count + " students");
	            }
	        }

	        return list;
	    }

	    public void updateFee(int studentId, String course, double fee, Connection connection) throws Exception {

	        String sql = "UPDATE registration SET fees_paid = ? WHERE student_id = ? AND course_name = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {

	            statement.setDouble(1, fee);
	            statement.setInt(2, studentId);
	            statement.setString(3, course);

	            int rows = statement.executeUpdate();

	            if (rows == 0) {
	                throw new Exception("No record found to update");
	            }
	        }
	    }

	
	    
	    
}
