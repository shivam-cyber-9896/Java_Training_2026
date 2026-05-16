package com.shivam.monocept.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shivam.monocept.studentcourse.Util.DBConnection;
import com.shivam.monocept.studentcourse.model.Student;

public class StudentDAO {
	public boolean addStudent(Student student) {

        boolean status = false;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query = "INSERT INTO students(student_name,email,phone,age,city) VALUES(?,?,?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(query);

            preparedStatement.setString(1,student.getStudentName());

            preparedStatement.setString(2,student.getEmail());

            preparedStatement.setString(3,student.getPhone());

            preparedStatement.setInt(4, student.getAge());

            preparedStatement.setString(5, student.getCity());

            int rows = preparedStatement.executeUpdate();

            if(rows > 0) {
                status = true;
            }
            
            preparedStatement.close();
            connection.close();
        } catch(Exception e) {
        	 System.out.println("Error ="+e);
        }

        return status;
    }
	public List<Student> getAllStudents() {

	    List<Student> students =
	            new ArrayList<>();

	    try {

	        Connection connection =
	                DBConnection.getConnection();

	        String query =
	                "SELECT * FROM students";

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        ResultSet resultSet =
	        		preparedStatement.executeQuery();

	        while(resultSet.next()) {

	            Student student =new Student();

	            student.setStudentId(resultSet.getInt("student_id"));

	            student.setStudentName(resultSet.getString("student_name"));

	            student.setEmail(resultSet.getString("email"));

	            student.setPhone(resultSet.getString("phone"));

	            student.setAge(resultSet.getInt("age"));

	            student.setCity(resultSet.getString("city"));

	            students.add(student);
	        }
	        resultSet.close();
            preparedStatement.close();
            connection.close();

	    } catch(Exception e) {
	    	 System.out.println("Error ="+e);
	    }

	    return students;
	}
	public Student getStudentById(int id) {

	    Student student = null;

	    try {

	        Connection connection =
	                DBConnection.getConnection();

	        String query =
	                "SELECT * FROM students WHERE student_id=?";

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        preparedStatement.setInt(1, id);

	        ResultSet resultSet =
	        		preparedStatement.executeQuery();

	        if(resultSet.next()) {

	            student = new Student();

	            student.setStudentId(
	            		resultSet.getInt("student_id"));

	            student.setStudentName(
	            		resultSet.getString("student_name"));

	            student.setEmail(
	            		resultSet.getString("email"));

	            student.setPhone(
	            		resultSet.getString("phone"));

	            student.setAge(
	            		resultSet.getInt("age"));

	            student.setCity(
	            		resultSet.getString("city"));
	        }
	        resultSet.close();
            preparedStatement.close();
            connection.close();
	    } catch(Exception e) {
	    	 System.out.println("Error ="+e);
	    }

	    return student;
	}
	public boolean updateStudent(Student student) {

	    boolean status = false;

	    try {

	        Connection connection =
	                DBConnection.getConnection();

	        String query =
	        "UPDATE students SET student_name=?,email=?,phone=?,age=?,city=? WHERE student_id=?";

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        preparedStatement.setString(1,
	                student.getStudentName());

	        preparedStatement.setString(2,
	                student.getEmail());

	        preparedStatement.setString(3,
	                student.getPhone());

	        preparedStatement.setInt(4,
	                student.getAge());

	        preparedStatement.setString(5,
	                student.getCity());

	        preparedStatement.setInt(6,
	                student.getStudentId());

	        int rows =
	        		preparedStatement.executeUpdate();

	        if(rows > 0){
	            status = true;
	        }
	        
            preparedStatement.close();
            connection.close();
	    } catch(Exception e){
	    	 System.out.println("Error ="+e);
	    }

	    return status;
	}
	public boolean deleteStudent(int id) {

	    boolean status = false;

	    try {

	        Connection connection =
	                DBConnection.getConnection();

	        String query =
	        "DELETE FROM students WHERE student_id=?";

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        preparedStatement.setInt(1, id);

	        int rows =
	        		preparedStatement.executeUpdate();

	        if(rows > 0){
	            status = true;
	        }
            preparedStatement.close();
            connection.close();
	    } catch(Exception e){
	        System.out.println("Error ="+e);
	    }

	    return status;
	}
	public boolean hasRegistrations(int studentId){

	    boolean status = false;

	    try {

	        Connection connection =
	                DBConnection.getConnection();

	        String query =
	        "SELECT * FROM registrations WHERE student_id=?";

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        preparedStatement.setInt(1, studentId);

	        ResultSet resultSet =
	        		preparedStatement.executeQuery();

	        if(resultSet.next()){

	            status = true;
	        }
	        resultSet.close();
            preparedStatement.close();
            connection.close();

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	    return status;
	}
}
