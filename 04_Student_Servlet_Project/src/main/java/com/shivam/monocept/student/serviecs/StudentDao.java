package com.shivam.monocept.student.serviecs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shivam.monocept.student.model.Student;
import com.shivam.monocept.student.utils.DBUtils;

public class StudentDao {
	public void addStudent(String name, String email, int age, String course, String batch) throws Exception {
		Connection connection=DBUtils.getConnection();
        String query = "INSERT INTO student_registration (student_name, email, age, course_name, batch_time) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setInt(3, age);
        statement.setString(4, course);
        statement.setString(5, batch);
         statement.executeUpdate();
         statement.close();
         connection.close();
	}
	public List<Student> getAllStudents() {
	    List<Student> list = new ArrayList<>();

	    try {
	        Connection con = DBUtils.getConnection();

	        String query = "SELECT * FROM student_registration";

	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Student s = new Student();

	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("student_name"));
	            s.setEmail(rs.getString("email"));
	            s.setAge(rs.getInt("age"));
	            s.setCourse(rs.getString("course_name"));
	            s.setBatch(rs.getString("batch_time"));

	            list.add(s);
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}
