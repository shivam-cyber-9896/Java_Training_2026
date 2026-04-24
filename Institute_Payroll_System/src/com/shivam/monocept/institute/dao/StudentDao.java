package com.shivam.monocept.institute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shivam.monocept.institute.model.Student;

public class StudentDao {
	
	 
 public void addStudent(Student student,Connection connection) throws SQLException, Exception
 {
	 String sql = "INSERT INTO student (id, name, age, branch) VALUES (?, ?, ?, ?)";
	 try (PreparedStatement statement=connection.prepareStatement(sql))
	 {
		 statement.setInt(1,student.getId());
		 statement.setString(2, student.getName());
		 statement.setInt(3, student.getAge());
		 statement.setString(4,student.getBranch());
		int check= statement.executeUpdate();
		if(check>0)
			System.out.println("addition of a student is succesfull");
		
		statement.close();
		 
	 }	
 }
 public Student getStudentById(int id,Connection connection) throws Exception {
     String sql = "SELECT * FROM student WHERE id = ?";

     try( PreparedStatement statement = connection.prepareStatement(sql)) {

         statement.setInt(1, id);
         ResultSet resultset = statement.executeQuery();

         if (resultset.next()) {
             return new Student(
                     resultset.getInt("id"),
                     resultset.getString("name"),
                     resultset.getInt("age"),
                     resultset.getString("branch")
             );
         }
     }
     
     
     return null;
 }
 
 public Student updateStudent(Student s, Connection connection) throws Exception {

	    String sql = "UPDATE student SET name=?, branch=? WHERE id=?";

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, s.getName());
	        statement.setString(2, s.getBranch());
	        statement.setInt(3, s.getId());

	        int rows = statement.executeUpdate();

	        if (rows == 0) {
	            throw new Exception(" Student not found for update");
	        }
	    }

	  
	    return this.getStudentById(s.getId(), connection);
	}
 public void deleteStudent(int id, Connection connection) throws Exception {
     String sql = "DELETE FROM student WHERE id=?";

     try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
         statement.executeUpdate();
     }
 }
 public boolean isStudentExists(int id, Connection connection) throws Exception {

	    String sql = "SELECT 1 FROM student WHERE id = ?";

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, id);

	        ResultSet rs = statement.executeQuery();

	        return rs.next(); 
	    }
	}
 public String getBranchName(int branchId, Connection con) throws Exception {

	 String sql = "SELECT branch FROM student WHERE id = ?";

	    try (PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, branchId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) 
	            return rs.getString("branch"); 	      
	            return null; 
	        
	    }
	}
}
