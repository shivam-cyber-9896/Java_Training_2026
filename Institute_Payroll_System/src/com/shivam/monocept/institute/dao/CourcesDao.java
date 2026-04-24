package com.shivam.monocept.institute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourcesDao {
	public void getCoursesByBranch(int branchId, Connection connection) throws Exception {

        String sql = "SELECT course_id, course_name FROM course WHERE branch_id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, branchId);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("course_id") + " - " + rs.getString("course_name"));
            }
        }
    }
    public String getCourseById(int courseId, Connection con) throws Exception {

        String sql = "SELECT course_name FROM course WHERE course_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, courseId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
                return rs.getString("course_name"); 
           
                throw new Exception("Course not found");
            
        }
    }
    public boolean isCourseAvailable(int branchId, int courseId, Connection connection) throws Exception {

        String sql = "SELECT 1 FROM course WHERE course_id=? AND branch_id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            ps.setInt(2, branchId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    public boolean isCourseExists(int courseId, Connection connection) throws Exception {

        String sql = "SELECT 1 FROM course WHERE course_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, courseId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
	
}
